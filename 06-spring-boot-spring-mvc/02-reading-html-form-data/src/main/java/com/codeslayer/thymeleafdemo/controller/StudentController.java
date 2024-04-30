package com.codeslayer.thymeleafdemo.controller;

import com.codeslayer.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {

    // controller method to display form
    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){
        // create the student object
        Student theStudent = new Student();

        // add the student object to the model(the MVC model attributes will be available in the html page)
        theModel.addAttribute("student", theStudent);

        return "student-form";
    }


    // controller method to process student form data and render the data
    // @ModelAttribute annotation is used to bind the student data from form with theStudent object
    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent){
        // validate form data
        System.out.println("The Student: " + theStudent.getFirstName() + " " + theStudent.getLastName());
        return "student-confirmation";
    }
}
