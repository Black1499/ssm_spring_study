package com.lzx.service;

import com.lzx.dao.EmployeeMapper;
import com.lzx.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    public List<Employee> selectAll(){
        return employeeMapper.selectAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = Exception.class)
    public int deleteEmployee(int id){
        return employeeMapper.deleteById(id);
    }

}
