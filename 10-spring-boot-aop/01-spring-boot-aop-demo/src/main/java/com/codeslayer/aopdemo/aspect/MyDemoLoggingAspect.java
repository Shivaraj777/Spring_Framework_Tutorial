package com.codeslayer.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
   @Aspect annotation is used to denote the class is an aspect
   Aspect is a class that contains a collections of related Advices
   Advice -> describes what action is taken and when it should be performed
   @Component annotation indicates that the class is a spring component and includes it for component scanning. It also registers the class as a spring bean.
*/
@Aspect
@Component
public class MyDemoLoggingAspect {

    /*
        "execution(public void addAccount())" -> pointcut expression
        pointcut expression -> a predicate expression which describes where advice should be applied
        @Before advice -> to run the method before the target object method -> public void addAccount()
        "execution(public void addAccount())" -> match all addAccount() irrespective of class
     */
    // @Before("execution(public void addAccount())")
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n========> Executing @Before Advice on addAccount()");
    }
}
