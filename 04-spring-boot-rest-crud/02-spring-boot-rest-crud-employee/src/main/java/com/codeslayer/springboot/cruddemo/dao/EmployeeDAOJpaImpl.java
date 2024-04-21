package com.codeslayer.springboot.cruddemo.dao;

import com.codeslayer.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // used to automatically register a class as DAO implementation for component scanning
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){ // entityManager is automatically created by spring boot
        this.entityManager = theEntityManager;
    }


    // implement findAll employees method
    @Override
    public List<Employee> findAll() {
        // create the query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

        // execute query and return the result
        return theQuery.getResultList();
    }


    // implement method to find a particular employee
    @Override
    public Employee findById(int employeeId) {
        Employee dbEmployee = entityManager.find(Employee.class, employeeId);
        return dbEmployee;
    }


    // implement method to add/update an employee data
    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);  // if employeeId == 0 -> save/insert, else -> update
        return dbEmployee;
    }


    // implement method to delete an employee
    @Override
    public void deleteById(int employeeId) {
        Employee dbEmployee = entityManager.find(Employee.class, employeeId);
        entityManager.remove(dbEmployee);
    }
}
