package com.codeslayer.cruddemo;

import com.codeslayer.cruddemo.dao.AppDAO;
import com.codeslayer.cruddemo.entity.*;
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
			// findInstructorWithCoursesJoinFetch(appDAO);
			// updateInstructor(appDAO);
			// updateCourse(appDAO);
			// deleteCourse(appDAO);
			// createCourseAndReviews(appDAO);
			// retrieveCourseAndReviews(appDAO);
			// deleteCourseAndReviews(appDAO);
			// createCourseAndStudents(appDAO);
			findCourseAndStudents(appDAO);
		};
	}


	// method to find a course and its associated students by connecting to DAO
	private void findCourseAndStudents(AppDAO appDAO) {
		int courseId = 10;
		System.out.println("Finding the course with id: " + courseId);
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(courseId);

		System.out.println("Course: " + tempCourse);
		System.out.println("Associated students: " + tempCourse.getStudents());
		System.out.println("Done!");
	}


	// method to create course and associated students by connecting to DAO
	private void createCourseAndStudents(AppDAO appDAO) {
		// create the course and students
		System.out.println("Creating the course and associated students...");
		Course tempCourse = new Course("Pacman - how to score one million points");
		Student tempStudent1 = new Student("Ram", "Singh", "ram@gmail.com");
		Student tempStudent2 = new Student("Rinku", "Sharma", "rinku@gmail.com");

		// add the students to course
		System.out.println("Adding the students to course...");
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		// save the course and associated students
		System.out.println("Saving the course: " + tempCourse);
		System.out.println("Saving the the students: " + tempCourse.getStudents());
		appDAO.save(tempCourse);
		System.out.println("Done");
	}


	// method to delete course and associated reviews by connecting to DAO
	private void deleteCourseAndReviews(AppDAO appDAO) {
		int courseId = 10;
		System.out.println("Deleting course with id: " + courseId);
		appDAO.deleteCourseById(courseId);  // this will delete the course and associated reviews as Cascade type is ALL
		System.out.println("Done!");
	}


	// method to get a course and its associated reviews by connecting to DAO
	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int courseId = 10;
		System.out.println("Finding course and associated reviews for id: " + courseId);
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(courseId);

		System.out.println("Course: " + tempCourse);
		System.out.println("Associated reviews: " + tempCourse.getReviews());
		System.out.println("Done!");
	}


	// method to create a course and its associated reviews by connecting to DAO
	private void createCourseAndReviews(AppDAO appDAO) {
		// create the course
		System.out.println("Creating a new course...");
		Course tempCourse = new Course("Pacman - How to score one million points.");

		// create reviews and add it to the course
		System.out.println("Adding reviews to the course...");
		tempCourse.addReview(new Review("Yo man.. great course!"));
		tempCourse.addReview(new Review("Easy to comprehend, thank you!"));
		tempCourse.addReview(new Review("The worst course I can find on the internet!"));

		// Save the course and associated reviews
		System.out.println("Saving the course...");
		System.out.println("Course: " + tempCourse);
		System.out.println("Reviews: " + tempCourse.getReviews());
		appDAO.save(tempCourse);
		System.out.println("Done!");
	}


	// method to delete a Course by connecting to DAO
	private void deleteCourse(AppDAO appDAO) {
		int courseId = 11;
		System.out.println("Deleting course with id: " + courseId);
		appDAO.deleteCourseById(courseId);
		System.out.println("Done");
	}


	// method to update Course by connecting to DAO
	private void updateCourse(AppDAO appDAO) {
		// find the course
		int courseId = 10;
		System.out.println("Finding the course with id: " + courseId);
		Course tempCourse = appDAO.findCourseById(courseId);

		// update the instructor
		System.out.println("Updating the course with id: " + courseId);
		tempCourse.setTitle("Finding Inner Peace - Master Class");
		appDAO.update(tempCourse);
		System.out.println("Done");
	}


	// method to update instructor by connecting to DAO
	private void updateInstructor(AppDAO appDAO) {
		// find the instructor
		int instructorId = 1;
		System.out.println("Finding the instructor with id: " + instructorId);
		Instructor tempInstructor = appDAO.findInstructorById(instructorId);

		// update the instructor
		System.out.println("Updating the instructor with id: " + instructorId);
		tempInstructor.setLastName("Darby");
		appDAO.update(tempInstructor);
		System.out.println("Done");
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
