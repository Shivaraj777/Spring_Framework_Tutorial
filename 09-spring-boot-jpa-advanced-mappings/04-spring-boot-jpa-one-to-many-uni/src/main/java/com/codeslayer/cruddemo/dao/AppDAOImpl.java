package com.codeslayer.cruddemo.dao;

import com.codeslayer.cruddemo.entity.Course;
import com.codeslayer.cruddemo.entity.Instructor;
import com.codeslayer.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository  // to include DAO for component scanning
public class AppDAOImpl implements AppDAO{

    // define entity manager field to connect to database
    private EntityManager entityManager;

    // inject EntityManager object using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    // method to save the instructor and instructor details in database
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        // saves the instructor and instructor detail data in database -> why?... -> CascadeType = ALL
        entityManager.persist(theInstructor);
    }


    // method to find the instructor by id
    @Override
    public Instructor findInstructorById(int instructorId) {
        // associated instructor details data is also retrieved, as the default behaviour of @OneToOne fetch type is eager
        return entityManager.find(Instructor.class, instructorId);
    }


    // method to delete instructor by id
    @Override
    @Transactional
    public void deleteInstructorById(int instructorId) {
        // retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, instructorId);

        // retrieve associated course
        List<Course> tempCourses = tempInstructor.getCourses();

        // break the association/references for all the courses which instructor is mapped to
        for(Course tempCourse : tempCourses){
            tempCourse.setInstructor(null);
        }

        // delete instructor(deletes both instructor and associated instructor details)
        entityManager.remove(tempInstructor);
    }


    // method to find instructor-detail by id
    @Override
    public InstructorDetail findInstructorDetailById(int instructorDetailId) {
        return entityManager.find(InstructorDetail.class, instructorDetailId);
    }


    // method to delete instructor-detail by id
    @Override
    @Transactional
    public void deleteInstructorDetailById(int instructorDetailId) {
        // retrieve the instructorDetail and delete it(deletes both instructor details and associated instructor)
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, instructorDetailId);
        entityManager.remove(tempInstructorDetail);
    }


    // method to find the list of associated courses for an instructor
    @Override
    public List<Course> findCoursesByInstructorId(int instructorId) {
        // create the query and set the parameter
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", instructorId);

        // execute the query
        List<Course> tempCourse = query.getResultList();
        return tempCourse;
    }


    // method to find instructor and its associated courses(using JOIN FETCH)
    // JOIN FETCH loads the data in an EAGER fashion even if Fetch Type of entity is LAZY
    // the below code will return Instructor and associated courses embedded
    @Override
    public Instructor findInstructorByIdJoinFetch(int instructorId) {
        // create the query to find instructor with JOIN FETCH
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i " +
                                                                "JOIN FETCH i.courses " +
                                                                "JOIN FETCH i.instructorDetail " +
                                                                "where i.id = :data", Instructor.class);

        query.setParameter("data", instructorId);

        // execute the query and return the result
        Instructor tempInstructor = query.getSingleResult();
        return tempInstructor;
    }


    // method to update instructor
    @Override
    @Transactional
    public void update(Instructor theInstructor) {
        entityManager.merge(theInstructor);
    }


    @Override
    public Course findCourseById(int courseId) {
        return entityManager.find(Course.class, courseId);
    }


    // method to delete a course based on id
    @Override
    @Transactional
    public void deleteCourseById(int courseId) {
        // retrieve the course and delete it
        Course tempCourse = entityManager.find(Course.class, courseId);
        entityManager.remove(tempCourse);
    }


    // method to create a course
    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }


    @Override
    @Transactional
    public void update(Course theCourse) {
        entityManager.merge(theCourse);
    }

}
