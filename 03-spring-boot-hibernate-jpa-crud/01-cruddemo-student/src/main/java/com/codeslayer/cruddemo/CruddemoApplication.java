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
			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			readStudent(studentDAO);
		};
	}


	// method to retrieve a student object from database from ID
	private void readStudent(StudentDAO studentDAO){
		// create a student object
		System.out.println("Creating new student...");
		Student tempStudent1 = new Student("Honami", "Ichinose", "ichinose@gmail.com");

		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent1);

		// display the id of the saved student
		int studentId = tempStudent1.getId();
		System.out.println("Saved student generated id: " + studentId);

		// retrieve student based on id: primary key
		System.out.println("Retrieving the created student with given id: " + studentId);
		Student retrievedStudent1 = studentDAO.findById(studentId);

		// display the student
		System.out.println("The retrieved student is: " + retrievedStudent1);
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


	// method to create multiple students
	private void createMultipleStudents(StudentDAO studentDAO){
		// create multiple students
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("Kakeru", "Ryuen", "ryuen@gmail.com");
		Student tempStudent2 = new Student("Suzune", "Horikita", "horikita@gmail.com");
		Student tempStudent3 = new Student("Hiyori", "Shiina", "hiyori@gmail.com");

		// save the student objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// display the ID of the saved students
		System.out.println("Saved student 1 generated ID: " + tempStudent1.getId());
		System.out.println("Saved student 2 generated ID: " + tempStudent2.getId());
		System.out.println("Saved student 3 generated ID: " + tempStudent3.getId());
	}
}
