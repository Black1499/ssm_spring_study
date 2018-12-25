package com.lzx.spring_data_jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringDataConfig.class);
        EmployeeService service = context.getBean(EmployeeService.class);
        System.out.println(service.findAll());
    }
}
