package com.lzx.spring.aop.jdbc;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;

@Aspect
public class UpdateAspect {

    @Pointcut("execution(* com.lzx.spring.aop.jdbc.EmployeeDAO.insert(..))")
    public void update() {
    }

    @Around("update()")
    public void around(ProceedingJoinPoint point) {
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();
            System.out.println("打开数据库连接");
            int num = (int) point.proceed();
            System.out.println(num);
            if (num != 0) {
                System.out.println("操作成功");
                JdbcUtil.close(null, null, connection);
                System.out.println("关闭数据库连接");
            } else {
                connection.rollback();
                System.out.println("操作失败");
            }
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
