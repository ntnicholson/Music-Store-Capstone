package com.capstone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
 
@Configuration
@EnableWebMvc
@ComponentScan
public class ThymeleafViewResolverConfig{ 
	//Multiple View Resolvers: https://o7planning.org/11257/use-multiple-viewresolvers-in-spring-boot
 
    @Bean
    public ViewResolver thymeleafViewResolver() {
 
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
 
        viewResolver.setTemplateEngine(thymeleafTemplateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setOrder(0);
 
        // Important!!
        // thyme/page1.html, th_page2.html, ...
        viewResolver.setViewNames(new String[] { "thyme/*" });
 
        return viewResolver;
    }
 
    // Thymeleaf template engine with Spring integration
    @Bean
    public SpringTemplateEngine thymeleafTemplateEngine() {
 
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
        templateEngine.setEnableSpringELCompiler(true);
 
        return templateEngine;
    }
 
    @Bean
    public SpringResourceTemplateResolver springResourceTemplateResolver() {
        return new SpringResourceTemplateResolver();
    }
 
    // Thymeleaf template resolver serving HTML 5
    @Bean
    public ITemplateResolver thymeleafTemplateResolver() {
 
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
 
        templateResolver.setPrefix("templates/");
        templateResolver.setCacheable(false);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
 
        return templateResolver;
    }
  
}
