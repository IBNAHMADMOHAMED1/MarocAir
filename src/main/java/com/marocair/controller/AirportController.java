package com.marocair.controller;

import com.marocair.models.model.Airport;
import com.marocair.models.table.TableAirport;

import java.sql.SQLException;
import java.util.*;

public class AirportController {
    private static Airport airport = new Airport();
    private static List<Airport> airports = new ArrayList<Airport>();

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    // get all airports
    public static List<TableAirport> getAllAirports() throws SQLException {
        return airport.getAllAirports();
    }

}
