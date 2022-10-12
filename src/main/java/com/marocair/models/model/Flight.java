package com.marocair.models.model;
import com.marocair.models.table.TableFlight;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Flight extends Model {

    private static ArrayList<TableFlight> flights = new ArrayList<TableFlight>();

    public Flight() {
        super();
        setTableName("Flight");
    }
    // get all flights
    public List<TableFlight> getAllFlights() throws SQLException {
        ResultSet rs = getAll();
        while (rs.next()) {
            System.out.println("_____________________________________________________");
            TableFlight flight = new TableFlight();
            flight.setFlight_id(rs.getInt("flight_id"));
            flight.setDeparture_airport_id(rs.getInt("departure_airport_id"));
            flight.setArrival_airport_id(rs.getInt("arrival_airport_id"));
            flight.setFight_number(rs.getInt("fight_number"));
            flight.setFlight_max_capacity(rs.getInt("flight_max_capacity"));
            flight.setDeparture_time(rs.getDate("departure_time"));
            flight.setArrival_time(rs.getDate("arrival_time"));
            flights.add(flight);
        }
        return flights;
    }

}

