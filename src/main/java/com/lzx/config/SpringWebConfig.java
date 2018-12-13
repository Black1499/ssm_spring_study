package com.lzx.config;

import com.lzx.web.EmployeeController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


//@ComponentScan(basePackages = "com.lzx.web")
@Configuration
@EnableWebMvc
public class SpringWebConfig {
    @Bean
    public EmployeeController getBookController(){
        return new EmployeeController();
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolverConfig(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public StandardServletMultipartResolver multipartResolverConfig(){
        return new StandardServletMultipartResolver();
    }

    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();//对静态资源的请求转发到容器缺省的servlet,而不使用 DispatcherServlet
    }
}
