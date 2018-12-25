package com.lzx.spring.JdbcTemplate;

import com.lzx.config.springconfig.SpringDaoConfig;
import com.lzx.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> selectAll(){
        String sql = "select * from employee";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }
    public Employee selectById(String id){
        String sql = "select * from employee where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},Employee.class);
    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringDaoConfig.class);
        JdbcTemplate template = context.getBean(JdbcTemplate.class);

        JdbcTemplateTest test = new JdbcTemplateTest();
        List<Map<String, Object>> list = test.selectAll();
        System.out.println(list.size());

        System.out.println(test.selectById("1"));
    }
}
