package com.codeslayer.springboot.cruddemo.dao;

import com.codeslayer.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();  // method declaration to find all employees frm db
}
