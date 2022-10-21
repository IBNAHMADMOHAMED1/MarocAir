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

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultSet result;
        String depart = request.getParameter("departAirport");
        String arrival = request.getParameter("ArrivalAirport");
        String travelClass = request.getParameter("travelClass");
        String departTime = request.getParameter("departDate");
        String arrivalTime = request.getParameter("arrivalDate");


        System.out.println(travelClass);

        Model model = new Model();

        Flights f = new Flights();

        List<Flights> flights = new ArrayList<>();


        String querys = "SELECT * FROM flight JOIN airport ON airport.airport_id JOIN price ON price.price_id WHERE price.price_class = '" + travelClass + "'";


        try {


            ResultSet rs = model.query(querys);
            while (rs.next()) {
                if (rs.next()) {

//                    System.out.println(depart + " " + arrival);
//                    System.out.println(travelClass);
//                    System.out.println(rs.getString("departure_airport_id") + " " + rs.getString("arrival_airport_id"));

                    String departQuerys = "SELECT * FROM airport WHERE airport_id = '" + depart + "' ";
                    String arrivalQuerys = "SELECT * FROM airport WHERE airport_id = '" + arrival + "' ";

                    result = model.query(departQuerys);
                    ResultSet resultSet = model.query(arrivalQuerys);

                    while (result.next()) {
                        if (resultSet.next()) {
//                            System.out.println(result.getString("airport_name") + " " + resultSet.getString("airport_name"));
                            f.setAirline_id(rs.getString("airline_id"));
                            f.setFlight_id(rs.getString("flight_id"));
                            f.setFlight_number(rs.getString("flight_number"));
                            f.setFlight_price_id(rs.getString("flight_price_id"));
                            f.setDeparture_time(result.getString("airport_name"));
                            f.setArrival_time(resultSet.getString("airport_name"));
                            f.setDeparture_hour(rs.getString("departure_hour"));
                            f.setArrival_hour(rs.getString("arrival_hour"));
                            f.setAirport_name(rs.getString("airport_name"));
                            f.setPrice(rs.getString("price_value"));
                            f.setSeatClass(rs.getString("price_class"));
                            flights.add(f);

                            HttpSession session=request.getSession();
                            session.setAttribute("flightId",rs.getString("flight_number"));


                            request.setAttribute("flightData", flights);
                            RequestDispatcher dispatcher = request.getRequestDispatcher("flightResvation.jsp");
                            dispatcher.forward(request, response);

                            response.sendRedirect("flightResvation.jsp");
                        }

                    }


                } else {
                    request.setAttribute("error", "error");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("flightResvation.jsp");
                    dispatcher.forward(request, response);
                    response.sendRedirect("flightResvation.jsp");

                    System.out.println("empty");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
