package com.codeslayer.springboot.cruddemo.rest;

import com.codeslayer.springboot.cruddemo.entity.Employee;
import com.codeslayer.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    /* api to add an employee to the db
       POST - /api/employees/
       @RequestBody annotation is used to assign the data from request body to api method parameter
    */
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // just in case they pass an id in json... set it to 0
        // this is to force a save of new employee instead of update
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }


    /* api to update an existing employee in db
       PUT - /api/employees
    */
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }


    /* api to delete an employee from db
       DELETE - /employees/{employeeId}
     */
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        // find the employee
        Employee tempEmployee = employeeService.findById(employeeId);

        // check if employee exists in db
        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found: " + employeeId);
        }

        // delete thr employee
        employeeService.deleteById(employeeId);
        return "Deleted employee with id: " + employeeId;
    }
}
