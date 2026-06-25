package org.example.securityexam.beforeApplication;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterTestConfig {
   @Bean
    public FilterRegistrationBean<CaramiFilter> CaramiFilter(){
       FilterRegistrationBean registrationBean = new FilterRegistrationBean<>();
       registrationBean.setFilter(new CaramiFilter());
       registrationBean.addUrlPatterns("/api/*");
       registrationBean.setOrder(1);
       return registrationBean;
   }

   @Bean
    public FilterRegistrationBean<FilterExam> Filter(){
       FilterRegistrationBean registrationBean = new FilterRegistrationBean<>();
       registrationBean.setFilter(new FilterExam());
       registrationBean.addUrlPatterns("/*");
       registrationBean.setOrder(2);
       return registrationBean;
   }

   @Bean
    public FilterRegistrationBean<UserFilter> userFilter(){
       FilterRegistrationBean registrationBean = new FilterRegistrationBean<>();
       registrationBean.setFilter(new UserFilter());
       registrationBean.addUrlPatterns("/users/*");
       registrationBean.setOrder(3);
       return registrationBean;
   }
}
