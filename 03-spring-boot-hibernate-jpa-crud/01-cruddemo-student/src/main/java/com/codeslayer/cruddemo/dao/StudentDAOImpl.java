package com.codeslayer.cruddemo.dao;

import com.codeslayer.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// defines the implementation for methods accessing and manipulating data in database
@Repository  // @Repository annotation is used to automatically register the class as DAO Implementation for component scanning
public class StudentDAOImpl implements StudentDAO{

    // define filed for Entity Manager
    private EntityManager entityManager;

    // inject Entity manager using Constructor Injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // implement the save method
    @Override
    @Transactional  // used while saving/updating data/object into database
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }
}
