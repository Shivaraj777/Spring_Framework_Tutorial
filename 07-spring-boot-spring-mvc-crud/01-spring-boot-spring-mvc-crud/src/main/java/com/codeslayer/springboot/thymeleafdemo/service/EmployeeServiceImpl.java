package com.codeslayer.springboot.thymeleafdemo.service;

import com.codeslayer.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.codeslayer.springboot.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  // @Service annotation is used to automatically denote the class as a Service implementation for component scanning
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    // inject employee repository using constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    // implement service method to delegate to JPA repository
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }


    // implement service method to connect to JPA repository fineById method
    @Override
    public Employee findById(int employeeId) {
        // Spring JPA repository makes use of Optionals(introduced part of Java 8)
        Optional<Employee> result = employeeRepository.findById(employeeId);

        Employee dbEmployee = null;
        if(result.isPresent()){
            dbEmployee = result.get();
        }
        return dbEmployee;  // connect to JPA repository findById method
    }


    // implement service method to connect to JPA repository save method
    // @Transactional -. remove @Transactional as Spring JPA repository provides this functionality
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }


    // implement service method to connect to JPA repository deleteById method
    // @Transactional
    @Override
    public void deleteById(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
