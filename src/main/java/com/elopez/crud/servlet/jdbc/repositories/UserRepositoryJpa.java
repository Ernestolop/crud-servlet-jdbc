package com.elopez.crud.servlet.jdbc.repositories;

import java.util.Optional;

import com.elopez.crud.servlet.jdbc.models.User;

public interface UserRepositoryJpa extends RepositoryJpa<User> {
    Optional<User> byName(String name);

}
