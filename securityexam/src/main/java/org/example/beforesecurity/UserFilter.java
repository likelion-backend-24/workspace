package org.example.beforesecurity;

import jakarta.servlet.*;

import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("UserFilter::: Thread Name : "+Thread.currentThread().getName());
    }
}
