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
        pointcut expression  ->  a predicate expression which describes where advice should be applied
        @Before advice -> to run the method before the target object method  ->  public void addAccount()
        ================================================================================================================================================================
        Pointcut expression types and wildcards for methods
        ================================================================================================================================================================
        "execution(public void addAccount())"  ->  match all addAccount() with return type void irrespective of class
        "execution(public void com.codeslayer.aopdemo.dao.AccountDAO.addAccount())"  ->  match addAccount() for the specified fully qualified class/interface
        "execution(public void add*())"  ->  match all methods starting with add...
        "execution(public * add*())"  ->  match all methods starting with add... and any return type
        ================================================================================================================================================================
        Pointcut expression types and wildcards for method parameters
        ================================================================================================================================================================
        "execution(* add*(com.codeslayer.aopdemo.entity.Account))"  -> match methods with as single Account object as parameter
        "execution(* add*(com.codeslayer.aopdemo.entity.Account, ..))"  ->  match methods with Account object param and any no. of arguments
        ..  ---> specifies we can pass any no. of arguments to the function
        "execution(* add*(..))"  ->  match methods with zero or any parameters
        "execution(* com.codeslayer.aopdemo.dao.*.*(..))"  -> match any class method for specified package(fully qualified path)
     */
    // @Before("execution(public void addAccount())")
    // @Before("execution(public void com.codeslayer.aopdemo.dao.AccountDAO.addAccount())")
    // @Before("execution(public void add*())")
    // @Before("execution(* add*(com.codeslayer.aopdemo.entity.Account))")
    // @Before("execution(* add*(com.codeslayer.aopdemo.entity.Account, ..))")
    // @Before("execution(* add*(..))")
    @Before("execution(* com.codeslayer.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n========> Executing @Before Advice on method");
    }
}
