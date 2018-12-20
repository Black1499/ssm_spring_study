package com.lzx.spring.aop.jdbc;

import com.lzx.entity.Employee;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Aspect
public class QueryAspect {


    @Pointcut("execution(* com.lzx.spring.aop.jdbc.EmployeeDAO.selectAll(..))")
    public void query() {
    }

    @Before("query()")
    public void before() throws SQLException {

    }

    @Around("query()")
    public <T> List<T> around(ProceedingJoinPoint point) throws SQLException {
        JdbcUtil.getConnection();
        Connection connection = JdbcUtil.threadLocal.get();
        try {
            return (List<T>) point.proceed();
        } catch (Throwable e) {
            JdbcUtil.rollBack(connection);
        } finally {
            JdbcUtil.close(null, null, connection);

        }
        return null;
    }


    @AfterReturning("query()")
    public void after() throws SQLException {

    }

    @AfterThrowing("query()")
    public void afterTrowing() {

    }
}
