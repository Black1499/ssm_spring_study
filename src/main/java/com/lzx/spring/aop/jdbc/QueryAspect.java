package com.lzx.spring.aop.jdbc;

import com.lzx.entity.Employee;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Aspect
public class QueryAspect {

    private Connection connection = null;
    private ResultSet resultSet = null;

    @Pointcut("execution(* com.lzx.spring.aop.jdbc.EmployeeDAO.selectAll(..))")
    public void query() {
    }

    @Before("query()")
    public void before() throws SQLException, ClassNotFoundException {
        connection = JdbcUtil.getConnection();
    }

    @Around("query()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        resultSet = (ResultSet) point.proceed();
        Employee employee = null;
        while (resultSet.next()) {
            employee = new Employee();
            employee.setId(Integer.parseInt(resultSet.getString(1)));
            employee.setName(resultSet.getString(2));
            employee.setSex(resultSet.getString(3));
            employee.setEducation(resultSet.getString(4));
            employee.setBigDecimal(resultSet.getString(5));
            System.out.println(employee.toString());
        }
    }


    @AfterReturning("query()")
    public void after() throws SQLException, ClassNotFoundException {
        JdbcUtil.close(resultSet, null, connection);
    }

    @AfterThrowing("query()")
    public void afterTrowing() {
        JdbcUtil.rollBack(connection);
    }
}
