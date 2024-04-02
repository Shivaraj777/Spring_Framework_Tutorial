package com.codeslayer.springCoreDemo.rest;

import com.codeslayer.springCoreDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private filed for dependency
    private Coach myCoach;

    // define the setter method for dependency injection
    // @Qualifier annotation is used to specify the constructor which bean to inject
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach){
        myCoach = theCoach;
    }

    // api to get the daily workout
    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkOut();
    }
}
