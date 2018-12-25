package com.lzx.spring_data_jpa;

import com.lzx.spring_data_jpa.dao.EmployeeDAO;
import com.lzx.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
}
