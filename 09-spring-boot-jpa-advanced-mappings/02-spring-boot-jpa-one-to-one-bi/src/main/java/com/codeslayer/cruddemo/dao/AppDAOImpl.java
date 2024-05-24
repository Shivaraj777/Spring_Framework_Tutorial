package com.codeslayer.cruddemo.dao;

import com.codeslayer.cruddemo.entity.Instructor;
import com.codeslayer.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        // retrieve the instructor and delete it(deletes both instructor and associated instructor details)
        Instructor tempInstructor = entityManager.find(Instructor.class, instructorId);
        entityManager.remove(tempInstructor);
    }


    // method to find instructor-detail by id
    @Override
    public InstructorDetail findInstructorDetailById(int instructorDetailId) {
        return entityManager.find(InstructorDetail.class, instructorDetailId);
    }
}
