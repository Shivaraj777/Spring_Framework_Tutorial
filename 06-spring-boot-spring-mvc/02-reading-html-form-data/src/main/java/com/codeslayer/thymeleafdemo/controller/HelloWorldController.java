package com.codeslayer.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    // controller method to display initial form
    @GetMapping("/showForm")
    public String showForm(){
        return "helloWorld-form";
    }

    // controller method to process HTML form
    @GetMapping("/processForm")
    public String processForm(){
        return "helloWorld";
    }
}
