package com.elopez.crud.servlet.jdbc.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import com.elopez.crud.servlet.jdbc.models.Product;
import com.elopez.crud.servlet.jdbc.repositories.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService {

    private ProductRepositoryImpl productRepository;

    public ProductServiceImpl(Connection connection) {
        this.productRepository = new ProductRepositoryImpl(connection);
    }

    @Override
    public List<Product> findAll() {
        try {
            return productRepository.findAll();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Product> findById(int id) {
        try {
            return Optional.ofNullable(productRepository.findById(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
