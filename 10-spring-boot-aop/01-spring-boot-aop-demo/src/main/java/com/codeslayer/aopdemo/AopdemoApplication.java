package com.codeslayer.aopdemo;

import com.codeslayer.aopdemo.dao.AccountDAO;
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
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO){
		// lambda expression - shorthand expression for creating an implementation for command runner
		return runner -> {
			// System.out.println("Hello");
			demoTheBeforeAdvice(theAccountDAO);
		};
	}


	// method to display demo for @Before Advice annotation in AOP
	private void demoTheBeforeAdvice(AccountDAO theAccountDAO) {
		// call the business method/target object method
		theAccountDAO.addAccount();
	}

}
