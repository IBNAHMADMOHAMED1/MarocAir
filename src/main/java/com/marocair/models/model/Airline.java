package com.marocair.models.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Airline {
    private int airline_id;
    private String airline_name;

    public int getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(int airline_id) {
        this.airline_id = airline_id;
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }

    public List<Airline> getAllAirline() throws SQLException, SQLException {
        String sql = "SELECT * FROM Airline";
        Model model = new Model();
        ResultSet resultSet = model.query(sql);
        List<Airline> airlines = new ArrayList<>();
        while (resultSet.next()) {
            Airline airline = new Airline();
            airline.setAirline_id(resultSet.getInt(1));
            airline.setAirline_name(resultSet.getString(2));
            airlines.add(airline);
        }
        return airlines;
    }

    public  String getAirlineName(int airline_id) throws SQLException
    {
        String sql = "SELECT airline_name FROM Airline WHERE airline_id = " + airline_id;
        Model model = new Model();
        ResultSet resultSet = model.query(sql);
        String airline_name = "";
        while (resultSet.next()) {
            airline_name = resultSet.getString(1);
        }
        return airline_name;
    }

}
