package com.codeslayer.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/*
    @Aspect annotation is used to denote the class as an aspect
    @Component annotation declares the class as a spring bean and includes it for component scanning
*/
@Aspect
@Component
public class DemoLoggingAspect {

    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());


    // setup pointcut declarations for controller, service and dao package
    @Pointcut("execution(* com.codeslayer.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage() {};

    @Pointcut("execution(* com.codeslayer.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage() {};

    @Pointcut("execution(* com.codeslayer.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage() {};


    // combine pointcut declarations to execute aspects for either controller/service/dao package
    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {};


    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){
        // display the target method
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("==========> in @Before: calling method: " + theMethod);

        // display the arguments of the target method
        // get the arguments
        Object theArgs[] = theJoinPoint.getArgs();

        // loop through and display args
        for(Object tempArg : theArgs){
            myLogger.info("===========> argument: " + tempArg);
        }
    }


    // add @AfterReturning advice
    // returning attribute contains the name of the returned object to be set as parameter in advice method
    // Object theResult -> the value returned from target method is auto-injected to theResult by spring aop
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){
        // display the target method
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("==========> in @After: calling method: " + theMethod);

        // display the data returned
        myLogger.info("==========> Result: " + theResult);
    }
}
