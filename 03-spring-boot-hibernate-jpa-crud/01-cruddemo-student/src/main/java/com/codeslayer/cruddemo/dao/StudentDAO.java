package com.codeslayer.cruddemo.dao;

import com.codeslayer.cruddemo.entity.Student;

import java.util.List;

// Interface for DAO(Data Access Object
// declares the methods used for accessing and manipulating the data in database
public interface StudentDAO {

    void save(Student theStudent);  // create and save a student

    Student findById(Integer id);  // retrieve the Student data based on ID

    List<Student> findAll();  // retrieve all students data

    List<Student> findByLastName(String theLastName);  // retrieve students based on lastName
}
