package org.person.generator.app.entity;

/**
 * Created by mac on 28.01.17.
 */
public interface IPersonality {
    String getLname();

    String getFname();

    String getPatronymic();

    String getGender();

    String getDate();

    String getPostcode();

    String getCity();

    String getStreet();

    int getHouse();

    int getApartment();

    String getPhone();

    String getLogin();

    String getPassword();

    String getColor();

    String getUserpic();

    void setLname(String lname);

    void setFname(String fname) ;

    void setPatronymic(String patronymic);

    void setCity(String city);

    void setStreet(String street);

    void setColor(String color);
}
