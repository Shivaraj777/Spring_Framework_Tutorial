package com.codeslayer.springboot.cruddemo.service;

import com.codeslayer.springboot.cruddemo.dao.EmployeeDAO;
import com.codeslayer.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // @Service annotation is used to automatically denote the class as a Service implementation for component scanning
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    // inject employee DAO using constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    // implement service method to delegate to DAO
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
