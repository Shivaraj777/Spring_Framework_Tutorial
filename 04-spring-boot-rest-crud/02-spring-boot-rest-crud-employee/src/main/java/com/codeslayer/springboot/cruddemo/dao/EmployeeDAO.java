package com.codeslayer.springboot.cruddemo.dao;

import com.codeslayer.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();  // method declaration to find all employees frm db

    public Employee findById(int employeeId);  // method declaration to find an employee from db

    public Employee save(Employee theEmployee);  //method to add/update an employee to db

    public void deleteById(int employeeId);  //method to delete an employee from db
}
