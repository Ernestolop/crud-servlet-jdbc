package com.elopez.crud.servlet.jdbc.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public static final String URL = "jdbc:postgresql://localhost:5432/jdbc_test";
    public static final String USER = "postgres";
    public static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
