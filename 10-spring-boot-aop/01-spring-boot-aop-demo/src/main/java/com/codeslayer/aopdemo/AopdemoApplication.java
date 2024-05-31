package com.codeslayer.aopdemo;

import com.codeslayer.aopdemo.dao.AccountDAO;
import com.codeslayer.aopdemo.dao.MembershipDAO;
import com.codeslayer.aopdemo.entity.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){
		// lambda expression - shorthand expression for creating an implementation for command runner
		return runner -> {
			// System.out.println("Hello");
			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
		};
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
