package org.example.securityexam.beforeApplication;

import jakarta.servlet.*;

import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        try {
            System.out.println("UserFilter: doFilter 실행전:: Thread Nmae" + Thread.currentThread().getName());

//        User user = new User("kang");
            User user = extractUserFromRequest(request);

            UserContext.setUser(user);

            chain.doFilter(request, response);


            System.out.println("UserFilter: doFilter 실행후:: Thread Nmae" + Thread.currentThread().getName());
        }finally {
            UserContext.clear();
        }

    }

    private User extractUserFromRequest(ServletRequest request){
        String name = request.getParameter("name");

        return new User(name);
    }
}
