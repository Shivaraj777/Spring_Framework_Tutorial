package com.codeslayer.cruddemo.dao;

import com.codeslayer.cruddemo.entity.Course;
import com.codeslayer.cruddemo.entity.Instructor;
import com.codeslayer.cruddemo.entity.InstructorDetail;
import com.codeslayer.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);  // method declaration to save an instructor into database

    Instructor findInstructorById(int instructorId);  // method declaration to find instructor by id

    void deleteInstructorById(int instructorId);  // method declaration to delete instructor by id

    InstructorDetail findInstructorDetailById(int instructorDetailId);  // method declaration to find instructorDetail by id

    void deleteInstructorDetailById(int instructorDetailId);  // method declaration to delete instructor detail by id

    List<Course> findCoursesByInstructorId(int instructorId);  // method to find the associated courses for an instructor id

    Instructor findInstructorByIdJoinFetch(int instructorId);  // method declaration to find instructor and associated courses

    void update(Instructor theInstructor);  // method declaration to update instructor

    void update(Course theCourse);  // method declaration to update a course

    Course findCourseById(int courseId);  // method declaration to find course based on id

    void deleteCourseById(int courseId);  // method declaration to delete course based on id

    void save(Course theCourse);  // method declaration to create a course

    Course findCourseAndReviewsByCourseId(int courseId);  // method declaration to find a course and associated reviews based on id

    Course findCourseAndStudentsByCourseId(int courseId);  // method declaration to find course and associated students based on course id

    Student findStudentAndCoursesByStudentId(int studentId);  // method declaration to find student and associated courses

    void update(Student theStudent);  // method to declaration to update a student
}
