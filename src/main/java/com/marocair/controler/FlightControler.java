package com.marocair.controler;


import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

import com.marocair.models.model.Flight;
import com.marocair.models.table.TableFlight;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet(name = "flightServlet", value = "/flight-servlet")
public class FlightControler extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String message="";
    private static Flight flight = new Flight();

    private static TableFlight tableFlight = new TableFlight();
    private static ArrayList<TableFlight> flights = new ArrayList<TableFlight>();


    public void init()  {
        message = "Hello KKKKKKKKKKKKKKKK";
        try {
            flights = (ArrayList<TableFlight>) flight.getAllFlights();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
        out.println("</tr>");
        for (int i = 0; i < flights.size(); i++) {
            out.println("<tr>");
            out.println("<td>" + flights.get(i) + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body></html>");


    }

}
