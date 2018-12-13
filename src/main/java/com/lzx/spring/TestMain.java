package com.lzx.spring;

import com.lzx.service.TestService;
import com.lzx.service.TestServiceImpl2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        // xml配置读取
//        ClassPathXmlApplicationContext context
//                = new ClassPathXmlApplicationContext("spring/spring-study.xml");
//        TestService serviceImpl = (TestService) context.getBean("serviceImpl1");
//        serviceImpl.print();

        // java配置读取
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        TestService bean = applicationContext.getBean(TestServiceImpl2.class);
        bean.print();
    }
}
