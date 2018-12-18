package com.lzx.spring.aop.demo;

import org.aspectj.lang.annotation.*;

@Aspect
public class AopTestAspect {

    @Pointcut("execution(* com.lzx.spring.aop.demo.AopTest.print(..))")
    public void print() {

    }

    @Before("print()")
    public void before() {
        System.out.println("启动打印机");
    }

    @After("print()")
    public void after() {
        System.out.println("关闭打印机");
    }

    @AfterReturning("print()")
    public void afterRunning() {
        System.out.println("正在打印。。。。。。。");
    }

    @AfterThrowing("print()")
    public void afterThrowing() {
        System.out.println("打印机坏了");
    }
}
