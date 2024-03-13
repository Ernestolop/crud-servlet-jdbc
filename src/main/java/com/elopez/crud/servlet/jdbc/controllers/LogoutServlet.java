package com.elopez.crud.servlet.jdbc.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Optional;

import com.elopez.crud.servlet.jdbc.services.LoginService;
import com.elopez.crud.servlet.jdbc.services.LoginServiceSessionImpl;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> name = auth.getName(req);
        if (name.isPresent()) {
            HttpSession session = req.getSession();
            session.invalidate();
        }
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
