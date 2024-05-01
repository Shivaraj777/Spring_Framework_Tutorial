package com.codeslayer.thymeleafdemo.controller;

import com.codeslayer.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    // private data member to store the list of countries to display on student-form
    // @Value annotation is used to inject a property to the variable from properties file
    @Value("${countries}")
    private List<String> countries;

    @Value("${programmingLanguages}")
    private List<String> programmingLanguages;

    @Value("${operatingSystems}")
    private List<String> operatingSystems;

    // controller method to display form
    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){
        // create the student object
        Student theStudent = new Student();

        // add the student object to the model(the MVC model attributes will be available in the html page)
        theModel.addAttribute("student", theStudent);

        // add the list of countries, Programming languages, Operating Systems to the MVC model
        theModel.addAttribute("countries", countries);
        theModel.addAttribute("programmingLanguages", programmingLanguages);
        theModel.addAttribute("operatingSystems", operatingSystems);

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
