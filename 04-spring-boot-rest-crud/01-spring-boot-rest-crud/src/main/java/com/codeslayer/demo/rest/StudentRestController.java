package com.codeslayer.demo.rest;

import com.codeslayer.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return theStudents.get(studentId);
    }
}
