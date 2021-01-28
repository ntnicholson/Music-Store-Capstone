package com.capstone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
 
@Configuration
public class JspViewResolverConfig {
 
    @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
         
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/"); //WEB-INF/views/
        viewResolver.setSuffix(".jsp");
        viewResolver.setContentType("application/x-www-form-urlencoded");
        
         
        // Make sure > Thymeleaf order & FreeMarker order.
        viewResolver.setOrder(1000);
         
        return viewResolver;
    }
     
}