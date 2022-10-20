package com.marocair.models.model;
import com.marocair.models.table.TableFlight;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Flight extends Model {


    //String sql = "SELECT f.flight_id, f.flight_number, f.departure_airport_id, f.arrival_airport_id, f.departure_time, f.arrival_time, f.flight_max_capacity, a.airline_name, d.airport_name as departure_airport_name, a2.airport_name as arrival_airport_name FROM Flight f JOIN Airport d ON f.departure_airport_id = d.airport_id JOIN Airport a2 ON f.arrival_airport_id = a2.airport_id JOIN Airline a ON f.airline_id = a.airline_id";
   // ResultSet rs = query(sql);
    public  List<TableFlight> getAllFlight() throws SQLException {
        List<TableFlight> flights = new ArrayList<TableFlight>();
        // qeury to get all flights join with airport and airline and flight price
        String sql = "SELECT f.flight_id, f.flight_number, f.departure_airport_id, f.arrival_airport_id, f.departure_time,  f.departure_hour, f.arrival_time,f.arrival_hour, f.flight_max_capacity, a.airline_name, d.airport_name as departure_airport_name, a2.airport_name as arrival_airport_name, fp.price_value FROM Flight f JOIN Airport d ON f.departure_airport_id = d.airport_id JOIN Airport a2 ON f.arrival_airport_id = a2.airport_id JOIN Airline a ON f.airline_id = a.airline_id JOIN price fp ON f.flight_price_id = fp.price_id;";
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
            flight.setPrice_value(rs.getDouble("price_value"));
            flights.add(flight);
        }
           if (flights.size() > 0) {
               System.out.println("flights.size() > 0");
           }
        return flights;
    }

    // create a new flight using method insert in the Model class
    // INSERT INTO flight( airline_id, flight_number, departure_airport_id, arrival_airport_id, departure_time, departure_hour, arrival_time, arrival_hour, flight_max_capacity, flight_price_id)
    public boolean createFlight(TableFlight data) throws SQLException {
        String sql = "INSERT INTO Flight (flight_id,airline_id, flight_number, departure_airport_id, arrival_airport_id, departure_time, departure_hour, arrival_time, arrival_hour, flight_max_capacity, flight_price_id) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = GetConnection();
        PreparedStatement stmt = conn.prepareStatement(sql); // connection is a variable in the Model class
        stmt.setInt(1, randomInt());
        stmt.setInt(2, data.getAirline_id());
        stmt.setString(3, data.getFlight_number());
        stmt.setInt(4, data.getDeparture_airport_id());
        stmt.setInt(5, data.getArrival_airport_id());
        stmt.setString(6, data.getDeparture_time());
        stmt.setString(7, data.getHeure_depart());
        stmt.setString(8, data.getArrival_time());
        stmt.setString(9, data.getHeure_arrivee());
        stmt.setInt(10, data.getFlight_max_capacity());
        stmt.setInt(11, data.getPrice_id());
        int result = stmt.executeUpdate();
        return result > 0;
    }

    public boolean deleteFlight(int id) throws SQLException {
        String sql = "DELETE FROM Flight WHERE flight_id = " + id;
        return delete(sql);
    }

    public String ginerateFlightNumber(String airline_name, String departure_airport_name, String arrival_airport_name) {
         return airline_name.substring(0, 2).toUpperCase() + departure_airport_name.substring(0, 1).toUpperCase() + arrival_airport_name.substring(0, 1).toUpperCase() + UUID.randomUUID().toString().substring(0, 4).toUpperCase();
    }

    public int randomInt()
    {
        int min = 10;
        int max = 999999;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }

    // getFlightById
    public TableFlight getFlightById(int id) throws SQLException {
        TableFlight flight = new TableFlight();
        String sql = "SELECT f.flight_id, f.flight_number, f.departure_airport_id, f.arrival_airport_id, f.departure_time, f.departure_hour, f.arrival_time, f.arrival_hour, f.flight_max_capacity, a.airline_name, d.airport_name as departure_airport_name, a2.airport_name as arrival_airport_name, fp.price_value FROM Flight f JOIN Airport d ON f.departure_airport_id = d.airport_id JOIN Airport a2 ON f.arrival_airport_id = a2.airport_id JOIN Airline a ON f.airline_id = a.airline_id JOIN price fp ON f.flight_price_id = fp.price_id WHERE f.flight_id = " + id;
        ResultSet rs = query(sql);
        if (rs.next()) {
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
            flight.setPrice_value(rs.getDouble("price_value"));
        }
        return flight;
    }

    // updateFlight
    public boolean updateFlight(TableFlight data,int id) throws SQLException {
        String sql = "UPDATE Flight SET airline_id = ?, departure_airport_id = ?, arrival_airport_id = ?, departure_time = ?, departure_hour = ?, arrival_time = ?, arrival_hour = ?, flight_max_capacity = ?, flight_price_id = ? WHERE flight_id = " + id;
        Connection conn = GetConnection();
        PreparedStatement stmt = conn.prepareStatement(sql); // connection is a variable in the Model class
        stmt.setInt(1, data.getAirline_id());
        stmt.setInt(2, data.getDeparture_airport_id());
        stmt.setInt(3, data.getArrival_airport_id());
        stmt.setString(4, data.getDeparture_time());
        stmt.setString(5, data.getHeure_depart());
        stmt.setString(6, data.getArrival_time());
        stmt.setString(7, data.getHeure_arrivee());
        stmt.setInt(8, data.getFlight_max_capacity());
        stmt.setInt(9, data.getPrice_id());

        int result = stmt.executeUpdate();
        return result > 0;
    }





}

