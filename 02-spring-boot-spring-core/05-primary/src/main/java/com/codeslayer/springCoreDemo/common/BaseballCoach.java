package com.codeslayer.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkOut(){
        return "Spend 30 mins on volley practice!";
    }
}
