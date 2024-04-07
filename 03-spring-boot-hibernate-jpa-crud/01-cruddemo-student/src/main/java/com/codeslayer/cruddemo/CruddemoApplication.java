package com.codeslayer.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// define a bean for creating command-line application
	// command line runner is a hook from spring boot framework
	// the below method is executed after all the spring beans are loaded
	@Bean
	public CommandLineRunner commandLineRunner(String[] args){
		// java lambda expression
		// it is a shorthand notation for providing an implementation of CommandRunner interface
		return runner -> {
			System.out.println("Hello");
		};
	}

}
