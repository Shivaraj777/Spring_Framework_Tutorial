package com.codeslayer.springboot.cruddemo.rest;

import com.codeslayer.springboot.cruddemo.dao.EmployeeDAO;
import com.codeslayer.springboot.cruddemo.dao.EmployeeDAOJpaImpl;
import com.codeslayer.springboot.cruddemo.entity.Employee;
import com.codeslayer.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


    /* api to expose/get the list of employees from db
       GET - /api/employees
    */
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }


    /* api to get an employee from db
       GET - /api/employees/{employeeId}
    */
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);  // connect to employee service findById method

        if(theEmployee == null){
            throw new RuntimeException("Employee ID not found: " + employeeId);
        }

        return theEmployee;
    }
}
