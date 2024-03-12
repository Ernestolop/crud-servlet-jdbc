package com.elopez.crud.servlet.jdbc.repositories;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    List<T> findAll() throws SQLException;
    T findById(int id) throws SQLException;
    void save (T t) throws SQLException;
    void delete(int id) throws SQLException;
}
