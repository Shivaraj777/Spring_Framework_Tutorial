package com.codeslayer.springCoreDemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy // Lazy annotation initializes the bean if dependency is required
public class TrackCoach implements Coach{

    public TrackCoach(){
        System.out.println("Inside constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut(){
        return "Run 20 laps of 800 meters!";
    }
}
