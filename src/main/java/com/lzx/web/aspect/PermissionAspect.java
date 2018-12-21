package com.lzx.web.aspect;

import com.lzx.web.exceptions.PowerException;
import com.lzx.entity.User;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Aspect
@Component
public class PermissionAspect {

    @Autowired
    HttpSession httpSession;

    @Pointcut("execution(* com.lzx.web.controller.EmployeeController.*(..))")
    public void emp() {
    }

    @Before("emp()")
    public void userFilter() throws PowerException {
        User user = (User) httpSession.getAttribute("admin");
        if (user.getPermission() < 4 ) {
            System.out.println("用户没有权限！！！！！");
            throw new PowerException("该用户没有权限");
        }
//        if(!"rose".equals(user.getName())){
//            System.out.println("用户没有权限！！！！！");
//            throw new PowerException("该用户没有权限");
//        }
    }
}
