package com.marocair.models.model;
import com.marocair.models.table.TableFlight;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Flight extends Model {


    //String sql = "SELECT f.flight_id, f.flight_number, f.departure_airport_id, f.arrival_airport_id, f.departure_time, f.arrival_time, f.flight_max_capacity, a.airline_name, d.airport_name as departure_airport_name, a2.airport_name as arrival_airport_name FROM Flight f JOIN Airport d ON f.departure_airport_id = d.airport_id JOIN Airport a2 ON f.arrival_airport_id = a2.airport_id JOIN Airline a ON f.airline_id = a.airline_id";
   // ResultSet rs = query(sql);
    public  List<TableFlight> getAllFlight() throws SQLException {
        List<TableFlight> flights = new ArrayList<TableFlight>();
        String sql = "SELECT f.flight_id, f.flight_number, f.departure_airport_id, f.arrival_airport_id, f.departure_time,f.departure_hour ,f.arrival_time, f.arrival_hour, f.flight_max_capacity, a.airline_name, d.airport_name as departure_airport_name, a2.airport_name as arrival_airport_name FROM Flight f JOIN Airport d ON f.departure_airport_id = d.airport_id JOIN Airport a2 ON f.arrival_airport_id = a2.airport_id JOIN Airline a ON f.airline_id = a.airline_id";
        ResultSet rs;
        rs = query(sql);


        if (rs == null) {
            System.out.println("rs null");
        }
        while (rs.next()) {
            TableFlight flight = new TableFlight();
            System.out.println("flight_id: " + rs.getInt("flight_id"));
            System.out.println("flight_number: " + rs.getString("flight_number"));
            flight.setFlight_id(rs.getInt("flight_id"));
            flight.setFlight_number(rs.getString("flight_number"));
            flight.setDeparture_airport_id(rs.getInt("departure_airport_id"));
            flight.setDeparture_time(rs.getString("departure_time"));
            flight.setHeure_depart(rs.getString("departure_hour"));
            flight.setArrival_time(rs.getString("arrival_time"));
            flight.setHeure_arrivee(rs.getString("arrival_hour"));
            flight.setFlight_max_capacity(rs.getInt("flight_max_capacity"));
            flight.setAirline_name(rs.getString("airline_name"));
            flight.setDeparture_airport_name(rs.getString("departure_airport_name"));
            flight.setArrival_airport_name(rs.getString("arrival_airport_name"));
            flights.add(flight);
        }
           if (flights.size() > 0) {
               System.out.println("flights.size() > 0");
           }
        return flights;
    }

    // create a new flight using method insert in the Model class
    public boolean createFlight(TableFlight data) throws SQLException {
        String sql = "INSERT INTO Flight (flight_number, departure_airport_id, arrival_airport_id, departure_time,, arrival_time, flight_max_capacity) ";
        return insert(sql);
    }




}

