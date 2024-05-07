package com.codeslayer.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {

    // controller method to display home page
    @GetMapping("/")
    public String showHome(){
        return "home";
    }


    // controller method to display leaders page
    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }


    // controller method to display systems page
    @GetMapping("/systems")
    public String showSystems(){
        return "systems";
    }
}
