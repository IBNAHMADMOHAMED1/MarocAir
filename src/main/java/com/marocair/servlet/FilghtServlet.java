package com.marocair.servlet;


import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.marocair.controller.FlightControler;
import com.marocair.models.model.Flight;
import com.marocair.models.table.TableFlight;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import static java.lang.System.out;

@WebServlet(value = "/flight")
public class FilghtServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private  static final  String  VIEW = "views/flight/";
    private static final  String BASE_URL = "http://localhost:8080/MarocAir_war_exploded/flight";

    private static String message;
    private static Flight flight = new Flight();

    private static TableFlight tableFlight = new TableFlight();
    private static List<TableFlight> flights = new ArrayList<TableFlight>();



    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        out.println(action);
        if (action == null) {
            action = "getAll";
        }
        switch (action) {
            case "getAll":
                try {
                    flights = flight.getAllFlight();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("flights", flights);
                request.getRequestDispatcher(VIEW + "index.jsp").forward(request, response);
                break;
            case "add":
                out.println("add");
                request.getRequestDispatcher(VIEW + "add.jsp").forward(request, response);
                break;
            case "edit":
                TableFlight flightid = null ;
                try {
                flightid = flight.getFlightById(Integer.parseInt(request.getParameter("id")));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                request.setAttribute("flight", flightid);
                request.getRequestDispatcher(VIEW + "edit.jsp").forward(request, response);
                break;
            case "delete":
                String id = request.getParameter("id");
                // message confirmation
                alertMessage(request, response, id);
                break;
            case "confirmDelete":
                String idDelete = request.getParameter("id");
                String message = null;
                 try {
                    flight.deleteFlight(Integer.parseInt(idDelete));
                    message = "Flight deleted successfully";
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("message", message);
                 // redirect base url with message expired in 3 seconds
                response.setHeader("Refresh", "3; URL=" + BASE_URL);
                request.getRequestDispatcher(VIEW + "index.jsp").forward(request, response);




                break;
            default:
                break;
        }

    }

    public void printMessage(HttpServletResponse response, String message, int time) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p style='color: green; font-size: 20px; text-align: center;' class = 'message'>" + message + "</p>");
        out.println("<script type=\"text/javascript\">");
        out.println("setTimeout(function(){window.location = '" + BASE_URL + "';}, " + time + ");");
        out.println("</script>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // get the data from the request
        // check if action is update
        String action = request.getParameter("action");
        out.println("action : " + action);
        String departure_time = request.getParameter("departure_time");
        String arrival_time = request.getParameter("arrival_time");
        int departure_airport_id = Integer.parseInt(request.getParameter("departure_airport_id"));
        out.println(request.getParameter("departure_airport_id"));
        int arrival_airport_id = Integer.parseInt(request.getParameter("arrival_airport_id"));
        String departure_hour = request.getParameter("departure_hour");
        String arrival_hour = request.getParameter("arrival_hour");
        int flight_price_id = Integer.parseInt(request.getParameter("flight_price_id"));
        out.println("jjjjjjjjjjj"+request.getParameter("flight_price_id"));
        int flight_max_capacity = Integer.parseInt(request.getParameter("flight_max_capacity"));
        int airline_id = Integer.parseInt(request.getParameter("airline_id"));
        FlightControler flightControler = new FlightControler();
        String message = null;
        if (action == null) {

            try {
                message = flightControler.createFlight(departure_time, arrival_time, departure_airport_id, arrival_airport_id, departure_hour, arrival_hour, flight_price_id, flight_max_capacity, airline_id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            request.setAttribute("message", message);
            response.setHeader("Refresh", "3; URL=" + BASE_URL);
            request.getRequestDispatcher(VIEW + "index.jsp").forward(request, response);
        } else if (action.equals("update")) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                message = flightControler.updateFlight(id, departure_time, arrival_time, departure_airport_id, arrival_airport_id, departure_hour, arrival_hour, flight_price_id, flight_max_capacity, airline_id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            request.setAttribute("message", message);
            response.setHeader("Refresh", "3; URL=" + BASE_URL);
            request.getRequestDispatcher(VIEW + "index.jsp").forward(request, response);
        }

    }

    public void destroy() {
    }

    // alertMessage used tailwindcss as style

    public void alertMessage(HttpServletRequest request, HttpServletResponse response, String id) throws IOException, ServletException {
        response.setContentType("text/html");
        // tailwindcss cdn  <script src="https://cdn.tailwindcss.com"></script> <link rel="stylesheet" href="https://cdn.tailwindcss.com">

        PrintWriter out = response.getWriter();
        out.println("<div class=\"fixed z-10 inset-0 overflow-y-auto\" aria-labelledby=\"modal-title\" role=\"dialog\" aria-modal=\"true\">");
        out.println("<div class=\"flex items-end justify-center min-h-screen pt-4 px-4 pb-20 text-center sm:block sm:p-0\">");
        out.println("<div class=\"fixed inset-0 bg-gray-500 bg-opacity-75 transition-opacity\" aria-hidden=\"true\"></div>");
        out.println("<span class=\"hidden sm:inline-block sm:align-middle sm:h-screen\" aria-hidden=\"true\">&#8203;</span>");
        out.println("<div class=\"inline-block align-bottom bg-white rounded-lg text-left overflow-hidden shadow-xl transform transition-all sm:my-8 sm:align-middle sm:max-w-lg sm:w-full\" role=\"dialog\" aria-modal=\"true\" aria-labelledby=\"modal-headline\">");
        out.println("<div class=\"bg-white px-4 pt-5 pb-4 sm:p-6 sm:pb-4\">");
        out.println("<div class=\"sm:flex sm:items-start\">");
        out.println("<div class=\"mt-3 text-center sm:mt-0 sm:ml-4 sm:text-left\">");
        out.println("<h3 class=\"text-lg leading-6 font-medium text-gray-900\" id=\"modal-headline\">");
        out.println("Delete Flight");
        out.println("</h3>");
        out.println("<div class=\"mt-2\">");
        out.println("<p class=\"text-sm text-gray-500\">");
        out.println("Are you sure you want to delete this flight?");
        out.println("</p>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"bg-gray-50 px-4 py-3 sm:px-6 sm:flex sm:flex-row-reverse\">");
        out.println("<button onclick=\"window.location.href = '" + BASE_URL + "?action=confirmDelete&id=" + id + "'\" type=\"button\" class=\"w-full inline-flex justify-center rounded-md border border-transparent shadow-sm px-4 py-2 bg-red-600 text-base font-medium text-white hover:bg-red-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-red-500 sm:ml-3 sm:w-auto sm:text-sm\">");
        out.println("Delete");
        out.println("</button>");
        out.println("<button onclick=\"window.location.href = '" + BASE_URL + "'\" type=\"button\" class=\"mt-3 w-full inline-flex justify-center rounded-md border border-gray-300 shadow-sm px-4 py-2 bg-white text-base font-medium text-gray-700 hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 sm:mt-0 sm:ml-3 sm:w-auto sm:text-sm\">");
        out.println("Cancel");
        out.println("</button>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("<script src=\"https://cdn.tailwindcss.com\"></script>");



    }


}

