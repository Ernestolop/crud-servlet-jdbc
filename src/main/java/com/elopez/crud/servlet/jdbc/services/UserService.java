package com.elopez.crud.servlet.jdbc.services;

import java.util.Optional;
import com.elopez.crud.servlet.jdbc.models.User;

public interface UserService {
    Optional<User> login(String name, String password);
}
