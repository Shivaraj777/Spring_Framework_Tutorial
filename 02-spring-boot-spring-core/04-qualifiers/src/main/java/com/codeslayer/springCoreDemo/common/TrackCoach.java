package com.codeslayer.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

    @Override
    public String getDailyWorkOut(){
        return "Run 20 laps of 800 meters!";
    }
}
