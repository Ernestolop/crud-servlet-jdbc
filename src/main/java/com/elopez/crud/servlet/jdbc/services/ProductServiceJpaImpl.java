package com.elopez.crud.servlet.jdbc.services;

import java.util.List;
import java.util.Optional;

import com.elopez.crud.servlet.jdbc.models.Product;
import com.elopez.crud.servlet.jdbc.repositories.ProductRepositoryImplJpa;
import com.elopez.crud.servlet.jdbc.repositories.RepositoryJpa;

import jakarta.persistence.EntityManager;

public class ProductServiceJpaImpl implements ProductService {

    EntityManager entityManager;
    RepositoryJpa<Product> productRepository;

    public ProductServiceJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.productRepository = new ProductRepositoryImplJpa(entityManager);
    }

    @Override
    public List<Product> findAll() {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Product> findById(int id) {
        try {
            return Optional.ofNullable(productRepository.findById(id));
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
    
}
