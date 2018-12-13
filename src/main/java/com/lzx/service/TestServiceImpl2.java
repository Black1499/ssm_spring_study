package com.lzx.service;

import org.springframework.stereotype.Component;

@Component
public class TestServiceImpl2 implements TestService {
    @Override
    public void print() {
        System.out.println("hello China");
    }
}
