package com.elopez.crud.servlet.jdbc.repositories;

import java.util.List;

public interface RepositoryJpa<T> {
    List<T> findAll();

    T findById(int id);

    void save(T t);

    void delete(int id);
}
