package com.marocair.controller;

import com.marocair.models.model.Model;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FlightSearch", value = "/FlightSearch")
public class FlightSearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = new Model();
        String sql = "SELECT * FROM airport";
        List<String> airports = new ArrayList<>();
        try {
            ResultSet rs = model.query(sql);

            while (rs.next()) {
                System.out.println(rs.getString("airport_name"));
                airports.add(rs.getString("airport_name"));
//                response.setAttribute
                request.setAttribute("airports", airports);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

  

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String depart = request.getParameter("depart");
//        String arrival = request.getParameter("arrival");
//        String departTime = request.getParameter("departDate");
//        String arrivalTime = request.getParameter("arrivalDate");
//
//
//        System.out.println(depart + " " + arrival + " " + departTime + " " + arrivalTime);
//
//        String querys = "SELECT * FROM airport JOIN flight ON flight_id WHERE flight.departure_airport_id = airport_id AND flight.arrival_airport_id = airport.airport_id";

    }
}
