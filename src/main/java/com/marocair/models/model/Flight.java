package com.marocair.models.model;
import java.sql.*;
import java.util.List;

public class Flight extends Model {
    private String id;
    private String departure;
    private String arrival;
    private String date;
    private String price;
    private static List<Flight> flights;

    public Flight() {
        super();
        setTableName("flight");
    }
    // get all flights
    public List<Flight> getFlights() throws SQLException {
        ResultSet rs = getAll();
        return flights;
    }
}

