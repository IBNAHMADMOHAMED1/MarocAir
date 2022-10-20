package com.marocair.controller;

import com.marocair.models.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Auth", value = "/Auth")
public class Auth extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = new User();

            String logged = user.AdminLogin(email, password);
            System.out.println(logged);
            if (!logged.equals("failed")) {
                HttpSession session = request.getSession();
                session.setAttribute("id", logged);
                String url = request.getRequestURL().substring(0, request.getRequestURL().length() - 4);
                response.sendRedirect(url + "admin/red.jsp");
            } else {
                System.out.println("failed to login");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
