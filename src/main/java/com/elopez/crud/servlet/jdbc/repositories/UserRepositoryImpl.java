package com.elopez.crud.servlet.jdbc.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.elopez.crud.servlet.jdbc.models.User;

public class UserRepositoryImpl implements UserRepository {

    private Connection connection;

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User byName(String name) throws SQLException {
        User user = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE name = ?");) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = getUser(resultSet);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    // agregar mientras los metodos con return null
    public List<User> findAll() throws SQLException {
        return null;
    }

    @Override
    public User findById(int id) throws SQLException {
        return null;
    }

    @Override
    public void save(User t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
    }

    private User getUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }

}
