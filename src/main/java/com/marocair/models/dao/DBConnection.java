package com.marocair.models.dao;

import java.sql.*;

public class DBConnection {
    // database connection
    private static final String URL = "jdbc:mysql://localhost:3306/marocair";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    // method returns a connection to the database
    public static Connection getConnection() throws java.sql.SQLException {
       return DriverManager.getConnection(URL, USERNAME, PASSWORD);

    }
    // method returns a statement object
    public static Statement getStatement() throws java.sql.SQLException {
        return getConnection().createStatement();
    }

}
