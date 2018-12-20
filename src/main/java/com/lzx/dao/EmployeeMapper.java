package com.lzx.dao;


import com.lzx.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {

    List<Employee> selectAll();

    int deleteById(int id);
}
