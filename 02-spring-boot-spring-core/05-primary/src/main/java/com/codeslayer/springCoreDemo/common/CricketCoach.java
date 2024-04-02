package com.codeslayer.springCoreDemo.common;

import org.springframework.stereotype.Component;

// Classes with @Component annotations are called as Spring Beans
@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkOut(){
        return "Practice Fast Bowling for 1 hour!!";
    }
}
