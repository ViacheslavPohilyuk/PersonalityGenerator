package org.person.generator.app.sql;

import java.sql.*;
import java.io.*;
import java.util.Properties;
/**
 * Created by mac on 30.01.17.
 */

public class DBConnection {
    private Connection conn = null;

    /** Read connection data from the properties file.
     *  And getting Connection object
     *  */
    public synchronized Connection getConnection()
    {
        Properties prop = new Properties();
        String absPath = "/Users/mac/IdeaProjects/PersonalityGenerator/src/main/resources/";
        try (FileInputStream input = new FileInputStream(absPath + "PropDB.properties")) {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Can't open file with the properties of the connection to the database");
        }

        try {
            String ssl = "?verifyServerCertificate=false&useSSL=true";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB" + ssl, prop);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
