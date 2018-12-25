package com.lzx.spring_data_jpa.dao;

import com.lzx.spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
