package com.lzx.config;

import com.lzx.service.TestServiceImpl1;
import com.lzx.service.TestServiceImpl2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @ComponentScan(basePackages = "com.lzx.service")

@Configuration
public class SpringServiceConfig {

    @Bean
    public TestServiceImpl1 getTestService1() {
        return new TestServiceImpl1();
    }

    @Bean
    public TestServiceImpl2 getTestService2() {
        return new TestServiceImpl2();
    }


}
