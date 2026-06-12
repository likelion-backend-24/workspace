package org.example.beforesecurity;

import jakarta.servlet.*;

import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("UserFilter: doFilter 실행전:: Thread Name : "+Thread.currentThread().getName());

        User user = new User("kang");
        UserContext.setUser(user);

        chain.doFilter(request,response);

        System.out.println("UserFilter: doFilter 실행후:: Thread Name : "+Thread.currentThread().getName());

    }
}
