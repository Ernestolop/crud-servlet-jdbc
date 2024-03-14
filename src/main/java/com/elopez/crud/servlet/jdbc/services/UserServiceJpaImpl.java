package com.elopez.crud.servlet.jdbc.services;

import java.util.Optional;

import com.elopez.crud.servlet.jdbc.models.User;
import com.elopez.crud.servlet.jdbc.repositories.UserRepositoryJpa;
import com.elopez.crud.servlet.jdbc.repositories.UserRepositoryJpaImpl;

import jakarta.persistence.EntityManager;

public class UserServiceJpaImpl implements UserService {
    EntityManager entityManager;
    UserRepositoryJpa userRepository;

    public UserServiceJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        userRepository = new UserRepositoryJpaImpl(entityManager);
    }

    @Override
    public Optional<User> login(String name, String password) {
        try {

            Optional<User> user = userRepository.byName(name);
            
            if (user.isPresent() && (user.get().getPassword() == null ? password == null : user.get().getPassword().equals(password))) {
                return user;
            } else {
                return Optional.empty();
            }

        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        } 
    }
}
