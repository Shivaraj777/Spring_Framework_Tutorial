package com.codeslayer.cruddemo.dao;

import com.codeslayer.cruddemo.entity.Instructor;
import com.codeslayer.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);  // method declaration to save an instructor into database

    Instructor findInstructorById(int instructorId);  // method declaration to find instructor by id

    void deleteInstructorById(int instructorId);  // method declaration to delete instructor by id

    InstructorDetail findInstructorDetailById(int instructorDetailId);  // method declaration to find instructorDetail by id

    void deleteInstructorDetailById(int instructorDetailId);  // method declaration to delete instructor detail by id
}
