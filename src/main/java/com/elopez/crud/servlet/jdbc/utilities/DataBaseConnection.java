package com.elopez.crud.servlet.jdbc.utilities;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataBaseConnection {
    public static final String URL = "jdbc:postgresql://localhost:5432/jdbc_test";
    public static final String USER = "postgres";
    public static final String PASSWORD = "1234";

    public static Connection getConnection() throws NamingException, SQLException {
        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource) envContext.lookup("jdbc/postgres");
        return ds.getConnection();
    }
}
