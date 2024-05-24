package com.codeslayer.cruddemo.dao;

import com.codeslayer.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);  // method declaration to save an instructor into database

    Instructor findInstructorById(int instructorId);  // method declaration to find instructor by id

    void deleteInstructorById(int instructorId);  // method declaration to delete instructor by id
}
