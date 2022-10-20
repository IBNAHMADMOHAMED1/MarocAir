package com.marocair.models.model;

import com.marocair.models.table.TableAirport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Airport extends Model {


    // getAll
    public List<TableAirport> getAllAirports()  throws SQLException {
        // query to get all airports
        String sql = "SELECT * FROM Airport";
        // create a list of airports
        List<TableAirport> airports = new ArrayList<TableAirport>();
        ResultSet rs;
        // get the result of the query
        rs = new Airport().query(sql);
        // loop through the result
        while (rs.next()) {
            // create a new airport
            TableAirport airport = new TableAirport();
            // set the airport id
            airport.setAirport_id(rs.getInt("airport_id"));
            // set the airport name
            airport.setAirport_name(rs.getString("airport_name"));
            // add the airport to the list
            airports.add(airport);
        }
        // return the list of airports
        return airports;
    }



}
