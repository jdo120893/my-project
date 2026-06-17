package org.example.securityexam.beforeApplication;

import jakarta.servlet.*;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
//@WebFilter(urlPatterns = "/api/*")

public class CaramiFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        System.out.println("CaramiFilter init() 실행 전");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)throws ServletException, IOException{
        System.out.println("CaramiFilter doFilter() 실행 전");

        filterChain.doFilter(request, response);

        System.out.println("CaramiFilter doFilter() 실행 후");

    }

    @Override
    public void destroy(){
        System.out.println("CaramiFilter destroy() ");
    }

}
