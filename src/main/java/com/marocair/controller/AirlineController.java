package com.marocair.controller;

import com.marocair.models.model.Airline;

import java.sql.SQLException;
import java.util.List;

public class AirlineController {

    public List<Airline> getAirlines() throws SQLException {
        Airline airline = new Airline();
        return airline.getAllAirline();
    }
}
