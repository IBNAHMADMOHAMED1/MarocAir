package com.marocair.models.dao;
import java.sql.*;
public class DBConnection {
    // database connection
    private static final String DB_NAME = "mf";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME ;
    // method returns a connection to the database
    public static Connection getConnection() throws SQLException {
        System.out.println("Connecting to database...");
       return DriverManager.getConnection(URL, USERNAME, PASSWORD);

    }
    // method returns a statement object
    public static Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }

}
