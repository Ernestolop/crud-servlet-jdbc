package com.elopez.crud.servlet.jdbc.repositories;

import java.util.List;

import com.elopez.crud.servlet.jdbc.models.Product;

import jakarta.persistence.EntityManager;

public class ProductRepositoryImplJpa implements RepositoryJpa<Product> {
    EntityManager entityManager;

    public ProductRepositoryImplJpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("select p from Product p", Product.class).getResultList();
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void save(Product product) {
        if (product.getId() == 0) {
            entityManager.persist(product);
        } else {
            entityManager.merge(product);
        }
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Product.class, id));
    }
}
