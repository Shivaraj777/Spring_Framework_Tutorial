package com.codeslayer.springCoreDemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// @Primary annotation is used to specify spring which Bean to inject by default if there are multiple beans
@Component
@Primary
public class TrackCoach implements Coach{

    @Override
    public String getDailyWorkOut(){
        return "Run 20 laps of 800 meters!";
    }
}
