package com.lzx.spring.aop.jdbc;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;

@Aspect
public class UpdateAspect {

    private Connection connection = null;

    @Pointcut("execution(* com.lzx.spring.aop.jdbc.EmployeeDAO.insert(..))")
    public void insert() {
    }

    @Before("insert()")
    public void before() throws SQLException {
        JdbcUtil.getConnection();
        connection = JdbcUtil.threadLocal.get();
        connection.setAutoCommit(false);
    }

    @Around("insert()")
    public int around(ProceedingJoinPoint point) throws Throwable {
        return (int) point.proceed();
    }

    @AfterReturning("insert()")
    public void after() throws SQLException {
        connection.setAutoCommit(true);
        JdbcUtil.close(null, null, connection);
    }

    @AfterThrowing("insert()")
    public void afterTrowing() {
        JdbcUtil.rollBack(connection);
    }
}
