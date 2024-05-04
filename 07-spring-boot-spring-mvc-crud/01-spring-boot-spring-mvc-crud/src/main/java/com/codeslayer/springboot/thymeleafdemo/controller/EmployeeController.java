package com.codeslayer.springboot.thymeleafdemo.controller;

import com.codeslayer.springboot.thymeleafdemo.entity.Employee;
import com.codeslayer.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "employees/list-employees";
    }


    // controller method to display create-employee-form
    // the employee attribute added to the MVC model scope is limited to employee-form page in this method
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        // create Employee object and add it to MVC model for binding form data with model
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";  // root directory -> resources/templates/*
    }


    // controller method to save the employee data
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        // save the employee
        employeeService.save(theEmployee);

        // redirect to employees list page -> (use redirect to prevent duplicate submissions)
        return "redirect:/employees/list";
    }


    // controller method to display employee-form pre-populated with employee-data
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int employeeId, Model theModel){
        // find the employee by ID and add it to model
        Employee theEmployee = employeeService.findById(employeeId);
        theModel.addAttribute("employee", theEmployee);
        return "/employees/employee-form";
    }
}
