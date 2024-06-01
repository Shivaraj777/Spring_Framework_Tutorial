package com.codeslayer.aopdemo.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{

    @Override
    public String getFortune() {
        return getFortune(false);
    }


    // return a fortune with exception handling case
    @Override
    public String getFortune(boolean tripWire) {
        if(tripWire){
            throw new RuntimeException("Major Accident! Highway is closed.");
        }
        // simulate a delay
        try{
            TimeUnit.SECONDS.sleep(5);  // delay the execution for 5 seconds
        }catch(Exception e){
            throw new RuntimeException();
        }

        return "Expect heavy traffic this morning!!";
    }
}
