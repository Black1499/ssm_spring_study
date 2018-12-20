package com.lzx.config;

import com.lzx.web.EmployeeController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.lzx.web")
@Configuration
@EnableWebMvc
public class SpringWebConfig {

//    @Bean
//    public EmployeeController getBookController() {
//        return new EmployeeController();
//    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolverConfig() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public StandardServletMultipartResolver multipartResolverConfig() {
        return new StandardServletMultipartResolver();
    }

}
