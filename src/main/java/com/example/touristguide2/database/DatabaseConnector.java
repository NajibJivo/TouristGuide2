package com.example.touristguide2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/Min_Touristguide_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "Ilove$occer2025"; /* Password for the database, (Insert MySQL password here) */


    static{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Read JDBC driver
            } catch (ClassNotFoundException e) {
               throw new RuntimeException("Fejl: JDBC driver kunne ikke indlæses", e);
            }
    }

    public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
