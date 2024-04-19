package com.codeslayer.demo.rest;

import com.codeslayer.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController  // define the class as a controller
@RequestMapping("/api")
public class StudentRestController {

    // api to return a list of Students
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Kiyotaka", "Ayanokoji"));
        students.add(new Student("Hiyori", "Shiina"));
        students.add(new Student("Suzune", "Horikita"));
        return students;
    }
}
