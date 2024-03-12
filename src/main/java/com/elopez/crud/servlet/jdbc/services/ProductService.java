package com.elopez.crud.servlet.jdbc.services;

import java.util.List;
import java.util.Optional;
import com.elopez.crud.servlet.jdbc.models.Product;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(int id);
}
