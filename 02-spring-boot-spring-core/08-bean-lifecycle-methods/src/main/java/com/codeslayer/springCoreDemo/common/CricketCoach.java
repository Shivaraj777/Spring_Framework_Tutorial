package com.codeslayer.springCoreDemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Classes with @Component annotations are called as Spring Beans
@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("Inside constructor: " + getClass().getSimpleName());
    }

    // define init method
    @PostConstruct
    public void afterStartUpWork(){
        System.out.println("In afterStartUpWork(): " + getClass().getSimpleName());
    }

    // define destroy method
    @PreDestroy
    public void cleanUpWork(){
        System.out.println("In cleanUpWork(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut(){
        return "Practice Fast Bowling for 1 hour!!";
    }
}
