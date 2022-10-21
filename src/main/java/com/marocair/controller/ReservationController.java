package com.marocair.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ReservationController", value = "/ReservationController")
public class ReservationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmailSender emailSender = new EmailSender();

        HttpSession session=request.getSession(false);
        String flightId =(String)session.getAttribute("flightId");

        String mail = emailSender.emailSender("za.tajer@gmail.com", flightId);

        System.out.println(mail);
    }
}
