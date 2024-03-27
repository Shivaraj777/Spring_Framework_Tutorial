package com.springboot.demo.myCoolApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Create a basic REST controller to display "Hello World"
@RestController
public class FunRestController {
    // injecting properties from application.properties file
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose new endpoint to return team info
    @GetMapping("/teamInfo")
    public String getTeamInfo(){
        return "Coach Name: " + coachName + "\t" + ", Team name: " + teamName;
    }

    // expose an "/" endpoint which returns "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    // expose a new endpoint for workout
    @GetMapping("/workout")
    public String getDailyWorkOut(){
        return "Run a hard 5K!";
    }

    // expose a new endpoint for fortune
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day";
    }
}
