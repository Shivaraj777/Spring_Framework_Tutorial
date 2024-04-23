package com.codeslayer.springboot.cruddemo.service;

import com.codeslayer.springboot.cruddemo.dao.EmployeeDAO;
import com.codeslayer.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    // implement service method to connect to DAO fineById method
    @Override
    public Employee findById(int employeeId) {
        return employeeDAO.findById(employeeId);  // connect to DAO findById method
    }


    // implement service method to connect to DAO save method
    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }


    // implement service method to connect to DAO deleteById method
    @Transactional
    @Override
    public void deleteById(int employeeId) {
        employeeDAO.deleteById(employeeId);
    }
}
