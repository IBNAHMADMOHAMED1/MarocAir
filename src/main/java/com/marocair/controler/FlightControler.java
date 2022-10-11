package com.marocair.controler;


import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet(name = "flightServlet", value = "/flight-servlet")
public class FlightControler extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String message="";

    public void init() {
        message = "Hello KKKKKKKKKKKKKKKK";
    }
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

}
