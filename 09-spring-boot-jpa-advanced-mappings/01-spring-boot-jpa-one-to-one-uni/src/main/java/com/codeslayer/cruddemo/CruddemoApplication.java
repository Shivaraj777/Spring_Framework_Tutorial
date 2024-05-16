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


	/*
		Command line function -> displays output on command line
		from spring boot framework... it is executed after the spring beans are loaded
	*/
	@Bean
	public CommandLineRunner commandLineRunner(String args[]){
		// lambda expression - shorthand expression for creating an implementation for command runner
		return runner -> {
			System.out.println("Hello World!");
		};
	}

}
