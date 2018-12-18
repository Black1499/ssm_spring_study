package com.lzx.spring.aop.jdbc;

import com.lzx.entity.Employee;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Aspect
public class QueryAspect {

    @Pointcut("execution(* com.lzx.spring.aop.jdbc.EmployeeDAO.selectAll(..))")
    public void query() {
    }

    @Around("query()")
    public void around(ProceedingJoinPoint point) {
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            System.out.println("打开数据库连接");
            ResultSet resultSet = (ResultSet) point.proceed();
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
            System.out.println("操作成功");
            JdbcUtil.close(resultSet, null, connection);
            System.out.println("关闭数据库连接");
        } catch (Throwable throwable) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                System.out.println("数据回滚");
            }
            System.out.println("操作失败");
        }
    }

}
