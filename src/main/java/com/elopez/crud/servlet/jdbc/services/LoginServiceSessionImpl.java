package com.elopez.crud.servlet.jdbc.services;

import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginServiceSessionImpl implements LoginService {
    @Override
    public Optional<String> getName(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        if (name != null) {
            return Optional.of(name);
        }
        return Optional.empty();
    }
}
