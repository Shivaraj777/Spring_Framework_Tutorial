package com.codeslayer.springboot.cruddemo.rest;

import com.codeslayer.springboot.cruddemo.dao.EmployeeDAO;
import com.codeslayer.springboot.cruddemo.dao.EmployeeDAOJpaImpl;
import com.codeslayer.springboot.cruddemo.entity.Employee;
import com.codeslayer.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    // inject employee service using constructor injection
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    // api to expose/get the list of employees from db
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }
}
