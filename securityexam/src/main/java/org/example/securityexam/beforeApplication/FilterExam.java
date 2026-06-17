package org.example.securityexam.beforeApplication;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
//import java.util.logging.Filter;

//@Component
//@WebFilter(urlPatterns = "/*")
//@Order(1)
public class FilterExam implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterExam init()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException{

        System.out.println("FilterExam doFilter() 실행 전!!" + Thread.currentThread().getName());
        chain.doFilter(request, response);

        System.out.println("FilterExam doFilter() 실행 후" + Thread.currentThread().getName());
    }

    @Override
    public void destroy(){
        System.out.println("FilterExam destory() ");
    }
}
