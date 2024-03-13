package com.elopez.crud.servlet.jdbc.services;

import java.util.Optional;
import jakarta.servlet.http.HttpServletRequest;

public interface LoginService {
    Optional<String> getName(HttpServletRequest request);
}
