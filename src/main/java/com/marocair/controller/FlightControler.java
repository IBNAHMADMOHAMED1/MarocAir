package com.marocair.controller;


import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.marocair.models.model.Airline;
import com.marocair.models.model.Flight;
import com.marocair.models.table.TableFlight;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
public class FlightControler {
    private static String message;
    private static Flight flight = new Flight();

    private static TableFlight tableFlight = new TableFlight();


    public void init() {

    }


    // getFlights method
    public List<TableFlight> getFlights() {
        List<TableFlight> flights = new ArrayList<TableFlight>();
        try {
            flights = flight.getAllFlight();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }

    public String generateFlightNumber(int airline_id) throws SQLException {
        Airline airline = new Airline();
        String airline_name = airline.getAirlineName(airline_id);
        // uuid
        String uuid = java.util.UUID.randomUUID().toString();
        String flight_number = airline_name.substring(0, 3).toUpperCase() + uuid.substring(0, 4).toUpperCase();
        return flight_number;
    }

    // create flight // (departure_time, arrival_time, departure_airport_id, arrival_airport_id, departure_hour, arrival_hour, flight_price_id, flight_max_capacity, airline_id)
    public String createFlight(String departure_time, String arrival_time, int departure_airport_id, int arrival_airport_id, String departure_hour, String arrival_hour, int flight_price_id, int flight_max_capacity, int airline_id) throws SQLException {
        String flight_number = generateFlightNumber(airline_id);
        tableFlight.setFlight_number(flight_number);
        data(departure_time, arrival_time, departure_airport_id, arrival_airport_id, departure_hour, arrival_hour, flight_price_id, flight_max_capacity, airline_id);
        flight.createFlight(tableFlight);
        message = "Flight created successfully";
        return message;
    }

    /// updateFlight
    public String updateFlight(int id, String departure_time, String arrival_time, int departure_airport_id, int arrival_airport_id, String departure_hour, String arrival_hour, int flight_price_id, int flight_max_capacity, int airline_id) throws SQLException {

        data(departure_time, arrival_time, departure_airport_id, arrival_airport_id, departure_hour, arrival_hour, flight_price_id, flight_max_capacity, airline_id);
        flight.updateFlight(tableFlight,id);
        message = "Flight updated successfully";
        return message;
    }

    private void data(String departure_time, String arrival_time, int departure_airport_id, int arrival_airport_id, String departure_hour, String arrival_hour, int flight_price_id, int flight_max_capacity, int airline_id) {
        tableFlight.setDeparture_time(departure_time);
        tableFlight.setArrival_time(arrival_time);
        tableFlight.setDeparture_airport_id(departure_airport_id);
        tableFlight.setArrival_airport_id(arrival_airport_id);
        tableFlight.setHeure_arrivee(arrival_hour);
        tableFlight.setHeure_depart(departure_hour);
        tableFlight.setPrice_id(flight_price_id);
        tableFlight.setFlight_max_capacity(flight_max_capacity);
        tableFlight.setAirline_id(airline_id);
    }


}
