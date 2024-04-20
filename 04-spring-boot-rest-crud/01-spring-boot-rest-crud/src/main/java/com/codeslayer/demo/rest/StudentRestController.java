package com.codeslayer.demo.rest;

import com.codeslayer.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController  // define the class as a controller
@RequestMapping("/api")
public class StudentRestController {
    List<Student> theStudents;

    // define Post construct method to create the student data only once when bean is created
    @PostConstruct
    private void loadStudentsData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Kiyotaka", "Ayanokoji"));
        theStudents.add(new Student("Hiyori", "Shiina"));
        theStudents.add(new Student("Suzune", "Horikita"));
    }


    // api to return a list of Students
    // route - /api/students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }


    // define api to get a particular student
    // route /api/students/{studentId}
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // check whether student ID exists
        if(studentId > theStudents.size() || studentId < 0){
            throw new StudentNotFoundException("Student ID not found: " + studentId);
        }

        return theStudents.get(studentId);
    }


    // add an exception handler to provide Student Error Response if student is not found
    // StudentErrorResponse -> type of the response body
    // StudentNotFoundException -> exception type
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception){
        // create an error response and set its values
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        // return the error response entity
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);  // errorResponse -> body, HttpStatus.NOT_FOUND -> status code
    }


    // exception handler for generic exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception){
        // create an error response and set its values
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        // return the error response entity
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
