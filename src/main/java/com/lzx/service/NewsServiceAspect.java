package com.lzx.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzx.entity.News;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;


import java.sql.SQLException;
import java.util.List;

// @Component
@Aspect
public class NewsServiceAspect {

    @Pointcut("execution(* com.lzx.service.NewsService.listAll(..))")
    public void listAll() {
    }

    @Before("listAll()")
    public void before() throws SQLException {

    }

    @Around("listAll()")
    public <T> List<T> around(ProceedingJoinPoint point) throws Throwable {
        ObjectMapper objectMapper = new ObjectMapper();
        String key = "news";
        Jedis jedis = new Jedis();
        if (!jedis.exists(key)) {
//            Class<?> aClass = point.getTarget().getClass();
//            Object o = aClass.newInstance();
            List<T> list = (List<T>) point.proceed();
            jedis.set(key, objectMapper.writeValueAsString(list));
            System.out.println("写入redis数据库");
            return list;
        } else {
            System.out.println("从redis中读取");
            List<T> newsList = objectMapper.readValue(jedis.get(key), new TypeReference<List<News>>() {
            });
            return newsList;
        }
    }


    @AfterReturning("listAll()")
    public void after() throws SQLException {

    }

}
