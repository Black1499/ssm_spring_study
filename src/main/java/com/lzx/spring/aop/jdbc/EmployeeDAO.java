package com.lzx.spring.aop.jdbc;

import com.lzx.entity.Employee;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class EmployeeDAO {

    public List<Employee> selectAll() throws SQLException, IllegalAccessException, NoSuchFieldException, InstantiationException {
       return JdbcUtil.executeQuery("select * from employee",Employee.class);
    }

    public int insert() throws SQLException, ClassNotFoundException {
        return JdbcUtil.executeUpdate("insert into employee values(?, ?, ?, ?, ?)", new Object[]{13, "张昂", "男", "本科", 3500});
    }

    public int delete(int id) throws SQLException, ClassNotFoundException {
        return JdbcUtil.executeUpdate("delete from employee where id = ?",new Object[]{id});
    }

}
