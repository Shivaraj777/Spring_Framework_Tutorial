package com.codeslayer.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


    // controller method to read form data and adding it to model
    // request -> to read and manipulate request data
    @GetMapping("processFormVersion2")
    public String processFormV2(HttpServletRequest request, Model theModel){
        // get form data from request and process it
        String theName = request.getParameter("studentName");
        theName.toUpperCase();
        String result = "Yo " + theName;

        // add the processed form data to spring MVC model
        theModel.addAttribute("message", result);
        return "helloWorld";
    }


    // controller method to read form data by using @RequestParam annotation and adding it to MVC model
    @PostMapping("processFormVersion3")
    public String processFormV3(@RequestParam("studentName") String theName, Model theModel){
        // get form data from request and process it
        // String theName = request.getParameter("studentName");
        theName = theName.toUpperCase();
        String result = "Hey my friend, from v3 " + theName;

        // add the processed form data to spring MVC model
        theModel.addAttribute("message", result);
        return "helloWorld";
    }

}
