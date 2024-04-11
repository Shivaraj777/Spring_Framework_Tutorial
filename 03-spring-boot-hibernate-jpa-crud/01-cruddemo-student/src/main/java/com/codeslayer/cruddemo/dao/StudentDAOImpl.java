package com.codeslayer.cruddemo.dao;

import com.codeslayer.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


    // implement findById method
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id); // Student.class -> Entity class name, id -> Student object id
    }


    // implement findAll method
    @Override
    public List<Student> findAll(){
        // create the query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ORDER BY lastName", Student.class);  // Student -> JPA Entity(Class) name, lastName -> JPA Entity field name

        // return query results
        return theQuery.getResultList();
    }


    // implement findByLastName method
    @Override
    public List<Student> findByLastName(String theLastName) {
        // create the query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);  // :theData -> JPQA named parameter -> to pass dynamic data in query

        // set the query parameters
        theQuery.setParameter("theData", theLastName);

        //return the query result
        return theQuery.getResultList();
    }
}
