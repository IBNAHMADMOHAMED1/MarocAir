package com.marocair.controller;


import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.marocair.models.model.Flight;
import com.marocair.models.table.TableFlight;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet(name = "flightServlet", value = "/flight-servlet")
public class FlightControler extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String message;
    private static Flight flight = new Flight();

    private static TableFlight tableFlight = new TableFlight();
    private static List<TableFlight> flights = new ArrayList<TableFlight>();


    public void init()  {
        message = "Hello World!";
    }
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        out.println("</tr>");
        for (TableFlight flight : flights) {
            out.println("<tr>");
            out.println("<td>" + flight.getFlight_id() + "</td>");
            out.println("<td>" + flight.getDeparture_airport_id() + "</td>");
            out.println("<td>" + flight.getArrival_airport_id() + "</td>");
            out.println("<td>" + flight.getFlight_number() + "</td>");
            out.println("<td>" + flight.getFlight_max_capacity() + "</td>");
            out.println("<td>" + flight.getDeparture_time() + "</td>");
            out.println("<td>" +  flight.getArrival_time()  + "</td>");
            out.println("<td>" + flight.getAirline_name() + "</td>");
            out.println("<td>" + flight.getDeparture_airport_name() + "</td>");
            out.println("<td>" + flight.getArrival_airport_name() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body></html>");
    }


}