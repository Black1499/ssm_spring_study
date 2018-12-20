package com.lzx.web;

import com.lzx.Exceptions.PowerException;
import com.lzx.web.LoginController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Aspect
@Component
public class PowerAspect {

    @Autowired
    HttpSession httpSession;

    @Pointcut("execution(* com.lzx.web.EmployeeController.*(..))")
    public void emp() {
    }

    @Before("emp()")
    public void powerFilter() throws PowerException {
        System.out.println("1111111111111");
        String name = (String) httpSession.getAttribute("admin");
        if (!name.equals("lzx")) {
            System.out.println("用户没有权限！！！！！");
            throw new PowerException("该用户没有权限");
        }
    }
}
