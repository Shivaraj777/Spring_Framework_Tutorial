package com.codeslayer.springCoreDemo.rest;

import com.codeslayer.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private filed for dependency
    private Coach myCoach;

    // define the constructor for dependency injection
    @Autowired
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }

    // api to get the daily workout
    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkOut();
    }
}
