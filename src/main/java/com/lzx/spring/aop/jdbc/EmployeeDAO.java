package com.lzx.spring.aop.jdbc;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeDAO {

    public ResultSet selectAll() throws SQLException, ClassNotFoundException {
       return JdbcUtil.executeQuery("select * from employee");
    }

    public int insert() throws SQLException, ClassNotFoundException {
        return JdbcUtil.executeUpdate("insert into employee values(?, ?, ?, ?, ?)", new Object[]{12, "张昂", "男", "本科", 3500});
    }

    public int delete(int id) throws SQLException, ClassNotFoundException {
        return JdbcUtil.executeUpdate("delete from employee where id = ?",new Object[]{id});
    }

}
