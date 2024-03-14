package com.elopez.crud.servlet.jdbc.controllers;

import java.io.IOException;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.elopez.crud.servlet.jdbc.models.Product;
import com.elopez.crud.servlet.jdbc.services.ProductService;
import com.elopez.crud.servlet.jdbc.services.ProductServiceJpaImpl;
import com.elopez.crud.servlet.jdbc.utilities.JpaUtil;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    private EntityManager entityManager = JpaUtil.getEntityManager();
    
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        ProductService productService = new ProductServiceJpaImpl(entityManager);
        List<Product> products = productService.findAll();
        
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/products.jsp").forward(request, response);
        
    }

}