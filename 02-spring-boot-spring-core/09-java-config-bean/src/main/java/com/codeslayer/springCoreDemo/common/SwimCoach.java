package com.codeslayer.springCoreDemo.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("Inside constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut(){
        return "Swim 1000 meters as a warmup";
    }
}
