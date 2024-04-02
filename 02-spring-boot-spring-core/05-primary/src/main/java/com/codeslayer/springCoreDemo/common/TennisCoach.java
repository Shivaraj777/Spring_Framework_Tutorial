package com.codeslayer.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkOut(){
        return "Practice backhand volley for 30 mins!";
    }
}
