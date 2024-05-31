package com.codeslayer.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {

    // provide the fully qualified path name of pointcut declaration to use it(if pointcut declaration is present in another class)
    @Before("com.codeslayer.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloudAdvice(){
        System.out.println("\n========> Logging to Cloud in Async fashion");
    }

}
