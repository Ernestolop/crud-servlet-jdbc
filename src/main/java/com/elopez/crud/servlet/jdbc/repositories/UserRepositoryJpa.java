package com.elopez.crud.servlet.jdbc.repositories;

import com.elopez.crud.servlet.jdbc.models.User;

public interface UserRepositoryJpa extends RepositoryJpa<User> {
    User byName(String name);

}
