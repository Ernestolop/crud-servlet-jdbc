package com.elopez.crud.servlet.jdbc.middlewares;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import com.elopez.crud.servlet.jdbc.services.ServiceJdbcException;
import com.elopez.crud.servlet.jdbc.utilities.DataBaseConnection;

@WebFilter("/*")
public class ConextionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try (Connection connection = DataBaseConnection.getConnection()) {

            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }

            try {
                request.setAttribute("connection", connection);
                chain.doFilter(request, response);
                connection.commit();
            } catch (SQLException | ServiceJdbcException e) {
                connection.rollback();
                e.printStackTrace();
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
