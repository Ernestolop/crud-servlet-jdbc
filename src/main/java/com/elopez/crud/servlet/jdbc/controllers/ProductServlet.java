package com.elopez.crud.servlet.jdbc.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.elopez.crud.servlet.jdbc.models.Product;
import com.elopez.crud.servlet.jdbc.services.ProductService;
import com.elopez.crud.servlet.jdbc.services.ProductServiceImpl;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        Connection connection = (Connection) request.getAttribute("connection");
        ProductService productService = new ProductServiceImpl(connection);
        List<Product> products = productService.findAll();
        
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/products.jsp").forward(request, response);
        
    }

}