package com.codeslayer.cruddemo;

import com.codeslayer.cruddemo.dao.StudentDAO;
import com.codeslayer.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			// readStudent(studentDAO);
			// readStudents(studentDAO);
			// queryStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}

	// method to delete all students
	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all the students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted rows count: " + numRowsDeleted);
	}

	// method to delete a student
	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 2;
		System.out.println("Deleting student with id: " + studentId);
		studentDAO.delete(studentId);
	}

	// method to update student data in database
	private void updateStudent(StudentDAO studentDAO) {
		// retrieve the student based on id
		int studentId = 2;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change the first name
		System.out.println("Updating student");
		myStudent.setFirstName("Arisu");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}


	// method tp fetch students based on lastName
	private void queryStudentsByLastName(StudentDAO studentDAO) {
		// get the list of students
		System.out.println("Retrieving the students with lastName from table...");
		List<Student> students = studentDAO.findByLastName("Ayanokoji");

		// display the list of students
		System.out.println("Displaying the students...");
		for(Student tempStudent : students){
			System.out.println(tempStudent);
		}
	}


	// method to fetch all students from database
	public void readStudents(StudentDAO studentDAO){
		// get the list of students
		System.out.println("Retrieving all the students from table...");
		List<Student> students = studentDAO.findAll();

		// display the list of students
		System.out.println("Displaying the students...");
		for(Student tempStudent : students){
			System.out.println(tempStudent);
		}
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
