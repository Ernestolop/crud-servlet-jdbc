package com.elopez.crud.servlet.jdbc.controllers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

import com.elopez.crud.servlet.jdbc.models.User;
import com.elopez.crud.servlet.jdbc.services.UserService;
import com.elopez.crud.servlet.jdbc.services.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session.getAttribute("name") != null) {
            response.sendRedirect(request.getContextPath() + "/products");
        } else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        UserService userService = new UserServiceImpl((Connection) request.getAttribute("connection"));
        Optional<User> userOptional = userService.login(name, password);

        if (userOptional.isPresent()) {
            HttpSession session = request.getSession();
            User user = userOptional.get();
            session.setAttribute("name", user.getName());
            response.sendRedirect(request.getContextPath() + "/products");
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid user or password");
        }
    }
}
