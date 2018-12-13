package com.lzx.dao;

import com.lzx.entity.Book;
import com.lzx.entity.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> selectAll();
}
