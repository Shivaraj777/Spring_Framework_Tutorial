package com.codeslayer.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    public BaseballCoach(){
        System.out.println("Inside constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut(){
        return "Spend 30 mins on volley practice!";
    }
}
