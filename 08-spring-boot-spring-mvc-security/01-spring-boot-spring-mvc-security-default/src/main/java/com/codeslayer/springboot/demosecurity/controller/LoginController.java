package com.codeslayer.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class LoginController {

    // controller method to display login page
    @GetMapping("/showMyLoginPage")
    public String showLoginPage(){
        // return "plain-login";
        return "bootstrap-login";
    }
}
