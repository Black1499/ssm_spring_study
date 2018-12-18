package com.lzx.spring.aop.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class JdbcAspect {

    @Pointcut("within(com.lzx.spring.aop.demo..*)")
    public void Jdbc() {
    }

    @Before("Jdbc()")
    public void before() {
        System.out.println("打开数据库连接");
    }

    @After("Jdbc()")
    public void after() {
        System.out.println("关闭数据库连接");
    }

    @AfterThrowing("Jdbc()")
    public void afterThrowing() {
        System.out.println("数据库连接异常");
    }

    @Around("Jdbc()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("开始执行：" + System.currentTimeMillis());
        point.proceed();
        System.out.println("结束执行：" + System.currentTimeMillis());

    }
}

