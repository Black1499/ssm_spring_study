package com.lzx.service;

import org.springframework.stereotype.Component;

@Component // 该注解只能用到类上
public class TestServiceImpl1 implements TestService {
    @Override
    public void print() {
        System.out.println("hello world");
    }
}
