package com.codeslayer.springboot.thymeleafdemo.controller;

import com.codeslayer.springboot.thymeleafdemo.entity.Employee;
import com.codeslayer.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    // controller action to get the list of employees
    @GetMapping("/list")
    public String getEmployees(Model theModel){
        // get the employees from database by connecting to employee service
        List<Employee> theEmployees = employeeService.findAll();

        // add the retrieved employees to the spring MVC model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }
}
