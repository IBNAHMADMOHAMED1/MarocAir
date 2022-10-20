package com.marocair.models.model;
import com.marocair.models.dao.DbConnection;
import com.marocair.models.table.TableAirport;

import java.sql.*;
import java.util.List;


public class Model extends DbConnection {
    public static void setTableName(String tableName) {
        Model.tableName = tableName;
    }

    private static String tableName="flight";



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
    public  Boolean delete(String sql) throws SQLException {
        return getStatement().execute(sql);
    }


}
