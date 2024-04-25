package com.codeslayer.springboot.cruddemo.dao;

import com.codeslayer.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// @RepositoryRestResource(path = "members")  // @RepositoryRestResource annotation is used to change the name of the entity in api url
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Employee -> Entity Type
    // Integer -> Primary key type

    // no need to write any implementation class code...
    // use the super class built-in methods by creating a reference of EmployeeRepository
}
