package com.codeslayer.cruddemo;

import com.codeslayer.cruddemo.dao.AppDAO;
import com.codeslayer.cruddemo.entity.Instructor;
import com.codeslayer.cruddemo.entity.InstructorDetail;
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
		AppDAO is injected automatically -> because the method is annotated with @Bean
	*/
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		// lambda expression - shorthand expression for creating an implementation for command runner
		return runner -> {
			// System.out.println("Hello World!");
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			// deleteInstructor(appDAO);
			findInstructorDetail(appDAO);
		};
	}

	// method to find instructor detail by connecting to DAO
	private void findInstructorDetail(AppDAO appDAO) {
		// get the instructor detail object
		int instructorDetailId = 2;
		System.out.println("Finding instructor detail with id: " + instructorDetailId);
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(instructorDetailId);

		// print instructor detail and associate instructor
		System.out.println("Instructor Detail: " + tempInstructorDetail);
		System.out.println("Associated Instructor: " + tempInstructorDetail.getInstructor());
	}


	// method to delete instructor by id by connecting to DAO
	private void deleteInstructor(AppDAO appDAO) {
		int instructorId = 1;
		System.out.println("Deleting the instructor with id: " + instructorId);
		appDAO.deleteInstructorById(instructorId);
		System.out.println("Done!!");
	}


	// method to find instructor by id by connecting to DAO
	private void findInstructor(AppDAO appDAO) {
		// find the instructor
		int instructorId = 1;
		System.out.println("Finding the instructor with id: " + instructorId);
		Instructor tempInstructor = appDAO.findInstructorById(instructorId);

		System.out.println("Instructor: " + tempInstructor);
		System.out.println("The associated instructor details: " + tempInstructor.getInstructorDetail());
	}


	// method to create instructor by connecting to DAO
	private void createInstructor(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor = new Instructor("Rock", "Dickson", "dickson@gmail.com");

		// create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		// Note: this will also save instructor_details -> why?... CascadeType.ALL
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
	}

}
