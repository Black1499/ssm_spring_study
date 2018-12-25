package com.lzx.redis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestRedis {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RedisConfig.class);
        RedisService bean = context.getBean(RedisService.class);
        bean.setKey("key", "value");
        System.out.println(bean.getValue("key"));

    }
}
