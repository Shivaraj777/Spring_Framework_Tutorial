package com.codeslayer.cruddemo;

import com.codeslayer.cruddemo.dao.AppDAO;
import com.codeslayer.cruddemo.entity.Course;
import com.codeslayer.cruddemo.entity.Instructor;
import com.codeslayer.cruddemo.entity.InstructorDetail;
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
			// findInstructorDetail(appDAO);
			// deleteInstructorDetail(appDAO);
			// createInstructorWithCourses(appDAO);
			// findInstructorWithCourses(appDAO);
			// findCoursesForInstructor(appDAO);
			findInstructorWithCoursesJoinFetch(appDAO);
		};
	}

	// method to find instructor and associated course with JOIN FETCH query by connecting to DAO
	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		// find instructor and associated courses
		int instructorId = 1;
		System.out.println("Finding instructor and associated courses with id: " + instructorId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(instructorId);

		// print the data
		System.out.println("Instructor: " + tempInstructor);
		System.out.println("Associated courses: " + tempInstructor.getCourses());
		System.out.println("Done");
	}


	// method to find the list of associated courses for an instructor bu connecting to DAO
	private void findCoursesForInstructor(AppDAO appDAO) {
		// find the instructor
		int instructorId = 1;
		System.out.println("Finding the instructor with id: " + instructorId);
		Instructor tempInstructor = appDAO.findInstructorById(instructorId);
		System.out.println("Instructor: " + tempInstructor);  // only instructor details will be loaded as fetch type is LAZY

		// find the associated courses for instructor and add it to instructor
		System.out.println("Finding courses for instructor id: " + instructorId);
		List<Course> tempCourses = appDAO.findCoursesByInstructorId(instructorId);
		tempInstructor.setCourses(tempCourses);
		System.out.println("The associated courses for Instructor: " + tempInstructor.getCourses());
		System.out.println("Done");
	}


	// method to find instructor and associated course
	// eager vs lazy load example overview -> we get error when we try to access courses as default fetch type is LAZY for @OneToMany mapping
	private void findInstructorWithCourses(AppDAO appDAO) {
		// find the Instructor
		int instructorId = 1;
		System.out.println("Finding instructor id: " + instructorId);
		Instructor tempInstructor = appDAO.findInstructorById(instructorId);

		// print instructor and associated courses
		System.out.println("Instructor: " + tempInstructor);
		System.out.println("The associated courses " + tempInstructor.getCourses());
		System.out.println("Done!");
	}


	// method to created instructor and associated courses
	private void createInstructorWithCourses(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor = new Instructor("Rock", "Dickson", "dickson@gmail.com");

		// create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some course
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball - Masterclass");

		// add the courses to the instructor
		tempInstructor.addCourse(tempCourse1);
		tempInstructor.addCourse(tempCourse2);

		// save the instructor
		System.out.println("Saving Instructor: " + tempInstructor);
		System.out.println("The Course: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}


	// method to delete instructor details by connecting to DAO
	private void deleteInstructorDetail(AppDAO appDAO) {
		int instructorDetailId = 3;
		System.out.println("Deleting the instructor detail with id: " + instructorDetailId);
		appDAO.deleteInstructorDetailById(instructorDetailId);
		System.out.println("Done!!");
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
