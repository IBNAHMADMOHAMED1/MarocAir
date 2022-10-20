package com.marocair.models.model;

import com.marocair.lib.HashPassword;
import com.marocair.models.dao.DbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User extends DbConnection {


    public String AdminLogin(String email, String password) throws SQLException {
        Model model = new Model();
        HashPassword hashPassword = new HashPassword();

        String sql = "SELECT * FROM admin WHERE email = '" + email + "' AND password = '" + password + "'";
        ResultSet res = model.query(sql);

        if (res.next()) {
            if (res.getString("email").equals(email)
                    && res.getString("password").equals(password)
            ) {
                System.out.println("loggged");
                return res.getString("id");
            } else {
                return "failed";
            }
        } else {
            return "no account founded";
        }
    }

}
