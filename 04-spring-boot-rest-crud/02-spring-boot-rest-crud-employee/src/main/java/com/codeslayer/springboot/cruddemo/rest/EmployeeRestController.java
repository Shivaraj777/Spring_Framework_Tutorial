package com.codeslayer.springboot.cruddemo.rest;

import com.codeslayer.springboot.cruddemo.dao.EmployeeDAO;
import com.codeslayer.springboot.cruddemo.dao.EmployeeDAOJpaImpl;
import com.codeslayer.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeDAO employeeDAO;

    // quick and dirty solution: inject employee DAO using constructor injection
    @Autowired
    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
        this.employeeDAO = theEmployeeDAO;
    }

    
    // api to expose/get the list of employees from db
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeDAO.findAll();
    }
}
