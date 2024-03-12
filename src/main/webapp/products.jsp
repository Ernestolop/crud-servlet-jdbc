<%@ page import="com.elopez.crud.servlet.jdbc.models.Product, java.util.List" %>
<%
    List<Product> productos = (List<Product>) request.getAttribute("products");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Products</title>
</head>
<body>
    <h1>Lista de productos</h1>
    <table>
        <thead>
            <tr>
                <th>Codigo</th>
                <th>Nombre</th>
                <th>Precio</th>
            </tr>
        </thead>
        <tbody>
            <% for(Product p: productos){ %>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getName() %></td>
                    <td><%= p.getPrice() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>