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
    private Coach anotherCoach;

    // define the constructor method for dependency injection
    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach theAnotherCoach){
        System.out.println("Inside constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    // api to get the daily workout
    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkOut();
    }

    // api to check bean scope reference type(singleton: true/prototype: false)
    @GetMapping("/check")
    public String checkBeanScopeReference(){
        return "Comparing Beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
