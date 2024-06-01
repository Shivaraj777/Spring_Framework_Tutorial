package com.codeslayer.aopdemo.aspect;

import com.codeslayer.aopdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/*
   @Aspect annotation is used to denote the class is an aspect
   Aspect is a class that contains a collections of related Advices
   Advice -> describes what action is taken and when it should be performed
   @Component annotation indicates that the class is a spring component and includes it for component scanning. It also registers the class as a spring bean.
   @Order annotation denotes the order in which aspect advices are run, lower the order -> higher the precedence
*/
@Aspect
@Component
@Order(2)
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

    /*
        JoinPoint object contains metadata about the target method call
        JoinPoint helps us to access target method arguments and signature
    */

    // @Before("execution(public void addAccount())")
    // @Before("execution(public void com.codeslayer.aopdemo.dao.AccountDAO.addAccount())")
    // @Before("execution(public void add*())")
    // @Before("execution(* add*(com.codeslayer.aopdemo.entity.Account))")
    // @Before("execution(* add*(com.codeslayer.aopdemo.entity.Account, ..))")
    // @Before("execution(* add*(..))")
    // @Before("execution(* com.codeslayer.aopdemo.dao.*.*(..))")
    // @Before("forDaoPackage()")    // apply the pointcut declaration to advice
    // @Before("forDaoPackageNoGetterSetter()")
    @Before("com.codeslayer.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n========> Executing @Before Advice on method");

        // display method signature
        MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + theMethodSignature);

        // display the method arguments
        Object args[] = theJoinPoint.getArgs();
        for(Object tempArg : args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){
                // downcast and print account specific details(convert from Object -> Account)
                Account theAccount = (Account) tempArg;
                System.out.println("Account Name: " + theAccount.getName());
                System.out.println("Account level: " + theAccount.getLevel());
            }
        }
    }



    /*
        @AfterReturning advice is executed immediately after the target method call's successfull execution
    */
    @AfterReturning(
            pointcut = "execution(* com.codeslayer.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "theAccounts")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> theAccounts){
        String methodName = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + methodName);
        System.out.println("\n=====>>> result is: " + theAccounts);

        // modify the account data
        if(!theAccounts.isEmpty()){
            Account tempAccount = theAccounts.get(0);
            tempAccount.setName("Daffy Duck");
        }
    }



    /*
        @AfterThrowing advice is executed when an exception is thrown in the target method
        throwing parameter and Throwable parameter theExc should have same name
    */
    @AfterThrowing(
            pointcut = "execution(* com.codeslayer.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc){
        // log the method name
        String methodName = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + methodName);

        // log the exception
        System.out.println("\n=====>>> The exception is: " + theExc.getMessage());
    }



    /*
        @After advice is executed after target method call is completed
        it is similar to finally block
    */
    @After("execution(* com.codeslayer.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyAccountsAdvice(JoinPoint theJoinPoint){
        String methodName = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (finally) on method: " + methodName);
    }



    /*
        @Around advice is executed Before and after the target method call
        ---> here we are printing the time taken for a method to execute
        ProceedingJoinPoint object --> is used to handle operations on target method
    */
    @Around("execution(* com.codeslayer.aopdemo.service.*.getFortune(..))")
    public Object aroundGetException(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
        // print the method we are advising on
        String methodName = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @Around on method: " + methodName);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // execute the target method
        Object result = theProceedingJoinPoint.proceed();

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n===========> Duration: " + duration/1000.0 + " seconds");
        return result;
    }

}
