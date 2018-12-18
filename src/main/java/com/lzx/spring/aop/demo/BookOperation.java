package com.lzx.spring.aop.demo;

import org.springframework.stereotype.Component;

@Component
public class BookOperation {
    public void insert(){
        System.out.println("插入数据、。。。");
    }
}
