package com.codeslayer.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
    a utility class which holds pointcut declarations and can be accessed by other Aspects
    if the class only contains pointcuts @Aspect annotation is optional   ---->   only required if the class contains advices
*/
@Aspect
public class AopExpressions {

    /*
        create a pointcut declaration
        we can re-use this pointcut declaration multiple times on any advices
     */
    @Pointcut("execution(* com.codeslayer.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {};

    // create a pointcut declaration to include getter methods for dao package
    @Pointcut("execution(* com.codeslayer.aopdemo.dao.*.get*(..))")
    public void getter() {};

    // create a pointcut declaration to include setter methods for dao package
    @Pointcut("execution(* com.codeslayer.aopdemo.dao.*.set*(..))")
    public void setter() {};

    // combine pointcut declaration to include package and exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {};
}
