package com.codeslayer.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class DemoController {

    // api to request Thymeleaf template -> which is rendered on browser
    @GetMapping("/hello")
    public String sayHello(Model theModel){  // theModel -> spring MVC model auto-configured
        // add an attribute to the model
        theModel.addAttribute("theDate", new java.util.Date());

        // spring mvc wil automatically search for helloWorld template in resources/templates and return the template
        return "helloWorld";
    }
}
