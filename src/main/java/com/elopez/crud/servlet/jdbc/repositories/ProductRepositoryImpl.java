package com.elopez.crud.servlet.jdbc.repositories;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.elopez.crud.servlet.jdbc.models.Product;

public class ProductRepositoryImpl implements Repository<Product> {

    private Connection connection;

    public ProductRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> products = new ArrayList<>();

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM products");) {
            while (resultSet.next()) {
                Product product = getProduct(resultSet);
                products.add(product);
            }
        }

        return products;
    }

    @Override
    public Product findById(int id) throws SQLException {
        Product product = new Product();

        try (
                PreparedStatement preparedStatement = connection
                        .prepareStatement("SELECT * FROM products WHERE id = ?");) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    product = getProduct(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public void save(Product t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub

    }

    private Product getProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getInt("price"));
        return product;
    }
}
