package com.codeslayer.cruddemo;

import com.codeslayer.cruddemo.dao.StudentDAO;
import com.codeslayer.cruddemo.entity.Student;
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
	// inject studentDAO for commandLineRunner
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		// java lambda expression
		// it is a shorthand notation for providing an implementation of CommandRunner interface
		return runner -> {
			// System.out.println("Hello");
			createStudent(studentDAO);
		};
	}

	// method to create a student
	private void createStudent(StudentDAO studentDAO){
		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Kiyotaka", "Ayanokoji", "kiyopon@gmail.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display the id of the saved student
		System.out.println("Saved student generated ID: " + tempStudent.getId());
	}
}
