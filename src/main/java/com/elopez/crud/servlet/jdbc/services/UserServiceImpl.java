package com.elopez.crud.servlet.jdbc.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import com.elopez.crud.servlet.jdbc.models.User;
import com.elopez.crud.servlet.jdbc.repositories.UserRepositoryImpl;

public class UserServiceImpl implements UserService {

    UserRepositoryImpl userRepository;

    public UserServiceImpl(Connection connection) {
        userRepository = new UserRepositoryImpl(connection);
    }

    @Override
    public Optional<User> login(String name, String password) {
        try {
            User user = userRepository.byName(name);
            if (user != null && (user.getPassword() == null ? password == null : user.getPassword().equals(password))) {
                return Optional.of(user);
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

}
