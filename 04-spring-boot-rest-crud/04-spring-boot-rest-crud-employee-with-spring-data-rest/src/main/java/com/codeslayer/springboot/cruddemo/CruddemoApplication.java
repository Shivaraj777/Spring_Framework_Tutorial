package com.codeslayer.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

}



/* in this project we will be using Spring JPA Repository to
   make connection to database
   Spring REST -> to create rest api endpoints automatically by scanning the JPA repositories

   App API url: http://localhost:8080/employees
   App API url after update: http://localhost:8080/spring-data-rest-api/members
   employees -> Name of the entity in lower case appended by s
*  */