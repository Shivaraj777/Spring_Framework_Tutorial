package com.codeslayer.springboot.cruddemo.service;

import com.codeslayer.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();  // service method to connect to employee JPA repository to get all employees

    public Employee findById(int employeeId);  // service method declaration to connect to JPA repository fineById method

    public Employee save(Employee theEmployee);  // service method declaration to connect to JPA repository save method

    public void deleteById(int employeeId);  // service method declaration to connect to JPA repository deleteById method
}
