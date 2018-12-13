package com.lzx.spring;

import com.lzx.service.TestService;
import com.lzx.service.TestServiceImpl1;
import com.lzx.service.TestServiceImpl2;
import org.springframework.context.annotation.*;

// @ImportResource(locations = "spring/spring-study.xml")
// 使用改注解同样可比将xml注入和下面的java注入混合使用
@ComponentScan // 等同于@Configuration
public class SpringBeanConfig {

    @Bean
    public TestServiceImpl1 getTestService1() {
        return new TestServiceImpl1();
    }

    @Bean
    public TestServiceImpl2 getTestService2() {
        return new TestServiceImpl2();
    }
}
