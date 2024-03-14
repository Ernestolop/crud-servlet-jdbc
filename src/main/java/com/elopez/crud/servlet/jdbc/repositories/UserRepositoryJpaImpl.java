package com.elopez.crud.servlet.jdbc.repositories;

import java.util.List;

import com.elopez.crud.servlet.jdbc.models.User;

import jakarta.persistence.EntityManager;

public class UserRepositoryJpaImpl implements UserRepositoryJpa{
    EntityManager entityManager;

    public UserRepositoryJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        if (user.getId() == 0) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User byName(String name) {
        return entityManager.createQuery("select u from User u where u.name = :name", User.class).setParameter("name", name).getSingleResult();
    }
}
