package com.lzx.web;

import com.lzx.dao.EmployeeMapper;
import com.lzx.entity.Employee;
import com.lzx.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.DELETE;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("emp")
    @ResponseBody
    public List<Employee> listEmployee() {
        return service.selectAll();
    }

    @GetMapping("/emp/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        service.deleteEmployee(id);
        return "delete success!!!!";
    }
}
