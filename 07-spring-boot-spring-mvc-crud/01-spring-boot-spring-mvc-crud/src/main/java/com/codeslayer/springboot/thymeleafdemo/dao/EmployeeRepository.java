package com.codeslayer.springboot.thymeleafdemo.dao;

import com.codeslayer.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Employee -> Entity Type
    // Integer -> Primary key type

    // no need to write any implementation class code...
    // use the super class built-in methods by creating a reference of EmployeeRepository
}
