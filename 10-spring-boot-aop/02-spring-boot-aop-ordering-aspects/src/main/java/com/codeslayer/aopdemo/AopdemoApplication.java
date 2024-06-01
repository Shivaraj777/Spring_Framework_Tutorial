package com.codeslayer.aopdemo;

import com.codeslayer.aopdemo.dao.AccountDAO;
import com.codeslayer.aopdemo.dao.MembershipDAO;
import com.codeslayer.aopdemo.entity.Account;
import com.codeslayer.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}


	/*
		Command line function -> displays output on command line
		from spring boot framework... it is executed after the spring beans are loaded
		AccountDAO is injected automatically -> because the method is annotated with @Bean
	*/
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TrafficFortuneService theTrafficFortuneService){
		// lambda expression - shorthand expression for creating an implementation for command runner
		return runner -> {
			// System.out.println("Hello");
			// demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			// demoTheAfterReturningAdvice(theAccountDAO);
			// demoTheAfterThrowingAdvice(theAccountDAO);
			// demoTheAfterAdvice(theAccountDAO);
			demoTheAroundAdvice(theTrafficFortuneService);
		};
	}


	// method to display demo for @Around Advice annotation in AOP
	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\n========> Main Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");
		String fortune = theTrafficFortuneService.getFortune();
		System.out.println("\nMy fortune is: " + fortune);
		System.out.println("Finished");
	}


	// method to display demo for @After Advice annotation in AOP
	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		// call the business method/target object method to find accounts
		List<Account> theAccounts = null;
		try{
			// add a boolean flag to simulate the exception
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}catch(Exception e){
			System.out.println("\n\nMain program: ...caught exception: " + e.getMessage());
		}

		System.out.println("Main program after throwing: " + theAccounts + "\n");
	}


	// method to display demo for @AfterThrowing Advice annotation in AOP
	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		// call the business method/target object method to find accounts
		List<Account> theAccounts = null;
		try{
			// add a boolean flag to simulate the exception
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}catch(Exception e){
			System.out.println("\n\nMain program: ...caught exception: " + e.getMessage());
		}

		System.out.println("Main program after throwing: " + theAccounts + "\n");
	}


	// method to display demo for @AfterReturning Advice annotation in AOP
	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		// call the business method/target object method to find accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		System.out.println("Main program after returning: " + theAccounts + "\n");
	}


	// method to display demo for @Before Advice annotation in AOP
	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		// call the business method/target object method
		Account myAccount = new Account("Rakesh", "25");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the Account DAO getter and setter methods
		theAccountDAO.setName("Rahul");
		theAccountDAO.setServiceCode("ytr765");
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		theMembershipDAO.addAccount();
		theMembershipDAO.addMember();
		theMembershipDAO.addMemberDetails();
		theMembershipDAO.goToSleep();
	}
}
