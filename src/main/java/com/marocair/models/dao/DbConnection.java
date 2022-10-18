package com.marocair.models.dao;
import java.sql.*;
import java.util.Properties;

public class DbConnection {
    // database connection
    private static final String DB_NAME = "newAir";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    private static final String URL = "jdbc:mysql://localhost:3306/newAir";


    // method returns a connection to the database
    public static Connection GetConnection()  {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;

    }

    // method returns a statement object
    public static Statement getStatement() throws SQLException {
        return GetConnection().createStatement();
    }

}