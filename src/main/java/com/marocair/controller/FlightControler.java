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

<<<<<<< HEAD
=======

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        flights = getFlights();
        if (flights.isEmpty())
            System.out.println("flights is empty");
        flights.forEach(flight -> System.out.println(flight.getFlight_number()));

        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<table border=\"1\">");
        out.println("<tr>");
        out.println("<th>flight_id</th>");
        out.println("<th>departure_airport_id</th>");
        out.println("<th>arrival_airport_id</th>");
        out.println("<th>fight_number</th>");
        out.println("<th>flight_max_capacity</th>");
        out.println("<th>departure_time</th>");
        out.println("<th>arrival_time</th>");
        out.println("<th>airline_name</th>");
        out.println("<th>departure_airport_name</th>");
        out.println("<th>arrival_airport_name</th>");
        out.println("<th>departure_airport_name</th>");
        out.println("<th>arrival_airport_name</th>");
        out.println("</th> Delete</th>");
        out.println("</th> Update</th>");
        out.println("</tr>");

        for (TableFlight flight : flights) {
            System.out.println(flight.getFlight_id());
            out.println("<tr>");
            out.println("<td>" + flight.getFlight_id() + "</td>");
            out.println("<td>" + flight.getDeparture_airport_id() + "</td>");
            out.println("<td>" + flight.getArrival_airport_id() + "</td>");
            out.println("<td>" + flight.getFlight_number() + "</td>");
            out.println("<td>" + flight.getFlight_max_capacity() + "</td>");
            out.println("<td>" + flight.getDeparture_time() + "</td>");
            out.println("<td>" + flight.getArrival_time() + "</td>");
            out.println("<td>" + flight.getAirline_name() + "</td>");
            out.println("<td>" + flight.getDeparture_airport_name() + "</td>");
            out.println("<td>" + flight.getArrival_airport_name() + "</td>");
            out.println("<td>" + flight.getHeure_depart() + "</td>");
            out.println("<td>" + flight.getHeure_arrivee() + "</td>");
            out.println("<td><a href=\"http://localhost:8080/flight-servlet?flight_id=" + flight.getFlight_id() + "\">Delete</a></td>");
            out.println("</td> <a href=\"http://localhost:8080/update-flight.jsp?flight_id=" + flight.getFlight_id() + "\">Update</a></td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body></html>");
    }

    // getFlights method
>>>>>>> f2712ff15ede9a527df489a90012b132c236c2c5
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
