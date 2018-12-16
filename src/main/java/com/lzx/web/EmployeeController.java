package com.lzx.web;

import com.lzx.dao.EmployeeMapper;
import com.lzx.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeMapper mapper;

    @GetMapping
    @ResponseBody
    public List<Employee> listEmployee() {
        return mapper.selectAll();
    }
}
