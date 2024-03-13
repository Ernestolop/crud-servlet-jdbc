package com.elopez.crud.servlet.jdbc.repositories;

import java.sql.SQLException;

import com.elopez.crud.servlet.jdbc.models.User;

public interface UserRepository extends Repository<User> {
    User byName(String name) throws SQLException;
}
