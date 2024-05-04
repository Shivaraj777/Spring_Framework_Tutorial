package com.codeslayer.springboot.thymeleafdemo.dao;

import com.codeslayer.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Employee -> Entity Type
    // Integer -> Primary key type

    // no need to write any implementation class code...
    // use the super class built-in methods by creating a reference of EmployeeRepository

    /*
       add method to sort employees by lastName
       Spring Data JPA will parse the method name...
       and looks for specific format and pattern and creates the query in the background
       findAllBy -> common pattern(syntax)
       JPA query method details -> www.lu2code.com/query-methods
    */
    public List<Employee> findAllByOrderByLastNameAsc();
}
