package com.lzx.spring.aop.jdbc;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeDAO {

    public ResultSet selectAll() throws SQLException, ClassNotFoundException {
       return JdbcUtil.executeQuery("select * from employee", null);
    }

    public int insert() throws SQLException, ClassNotFoundException {
        return JdbcUtil.executeUpdate("insert into employee values(?, ?, ?, ?, ?)", new Object[]{9, "张昂", "男", "本科", 3500});
    }
}
