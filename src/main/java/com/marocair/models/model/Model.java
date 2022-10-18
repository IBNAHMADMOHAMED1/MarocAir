package com.marocair.models.model;

import java.sql.*;
import com.marocair.models.dao.DBConnection;

public class Model extends DBConnection {
    public static void setTableName(String tableName) {
        Model.tableName = tableName;
    }

    private static String tableName;


    public ResultSet getAll() throws SQLException {
        String sql = "SELECT * FROM " + tableName;
        return getStatement().executeQuery(sql);
    }
    public ResultSet get(String column, String value) throws SQLException {
        String sql = "SELECT * FROM " + tableName + " WHERE " + column + " = '" + value + "'";
        return getStatement().executeQuery(sql);
    }

    public ResultSet query(String sql) throws SQLException {
        return getStatement().executeQuery(sql);
    }

    // method to insert data into the database
    public Boolean insert(String sql) throws SQLException {
        return getStatement().execute(sql);
    }

}
