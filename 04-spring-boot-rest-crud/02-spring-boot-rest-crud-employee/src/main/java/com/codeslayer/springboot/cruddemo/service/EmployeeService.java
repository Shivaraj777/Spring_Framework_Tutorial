package com.codeslayer.springboot.cruddemo.service;

import com.codeslayer.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();  // service method to connect to employee DAO to get all employees
}
