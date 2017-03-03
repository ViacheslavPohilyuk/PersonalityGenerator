package org.person.generator.app.sql;

import org.person.generator.app.entity.Personality;
import org.person.generator.app.entity.processing.Color;
import org.person.generator.app.entity.processing.Date;
import org.person.generator.app.entity.processing.DoubleName;
import org.person.generator.app.entity.processing.Transliteration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by mac on 30.01.17.
 */
public class PersonUpdate {
    private Connection conn;
    private Personality person;

    public PersonUpdate(Connection connection, Personality person) {
        this.conn = connection;
        this.person = person;
    }

    public void doUpdate() {
        try (PreparedStatement queryUpdate = conn.prepareStatement(sql())) {
            conn.setAutoCommit(false);
            processData();
            setParameters(queryUpdate);
            queryUpdate.executeUpdate();
            conn.commit();

        }
        catch (SQLException e) {
            e.printStackTrace();
            if(conn != null) {
                try {
                    System.err.println("Transaction is being rolled back");
                    conn.rollback();
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        finally {
            try {
                conn.setAutoCommit(true);
            }
            catch (SQLException e) {
                System.err.println("Setting auto commit error!");
                e.printStackTrace();
            }
        }
    }

    private void processData() {
        /* Transliteration from cyrillic to latin */
        Transliteration trl = new Transliteration();
        /* Convert russian colors to english */
        Color colorProcess = new Color(person.getColor());
        /* Truncation the double first names */
        DoubleName nameProcess = new DoubleName();

        /* Processing */
        person.setLname(trl.translit(person.getLname()));
        person.setFname(nameProcess.nameProcess(trl.translit(person.getFname())));
        person.setPatronymic(trl.translit(person.getPatronymic()));
        person.setCity(trl.translit(person.getCity()));
        person.setStreet(trl.translit(person.getStreet()));
        person.setColor(colorProcess.colorSwap());
    }

    private void setParameters(PreparedStatement preparedStatement) throws SQLException {
        Date dateProcess = new Date(person.getDate());

        preparedStatement.setString(1,  person.getLname());
        preparedStatement.setString(2,  person.getFname());
        preparedStatement.setString(3,  person.getPatronymic());
        preparedStatement.setString(4,  person.getGender());
        preparedStatement.setObject(5,  dateProcess.getLocaleDate());
        preparedStatement.setString(6,  person.getPostcode());
        preparedStatement.setString(7,  person.getCity());
        preparedStatement.setString(8,  person.getStreet());
        preparedStatement.setInt(   9,  person.getHouse());
        preparedStatement.setInt(   10, person.getApartment());
        preparedStatement.setString(11, person.getPhone());
        preparedStatement.setString(12, person.getLogin());
        preparedStatement.setString(13, person.getPassword());
        preparedStatement.setString(14, person.getColor());
        preparedStatement.setString(15, person.getUserpic());
    }

    private String sql() {
        return "INSERT INTO DB.Person("
                + "LastName, FirstName, Patronymic, Gender, BirthDate, "
                + "Postcode, City, Street, House, Apartment, "
                + "Phone, Login, Passwordd, Color, Userpic)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}
