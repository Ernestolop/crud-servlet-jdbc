package com.elopez.crud.servlet.jdbc.filters;

import java.io.IOException;
import java.util.Optional;

import com.elopez.crud.servlet.jdbc.services.LoginService;
import com.elopez.crud.servlet.jdbc.services.LoginServiceSessionImpl;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/products")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        LoginService service = new LoginServiceSessionImpl();
        Optional<String> nameOptional = service.getName((HttpServletRequest) request);
        if (nameOptional.isPresent()) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "Lo sentimos no estas autorizado para ingresar a esta pagina!");
        }
    }
}
