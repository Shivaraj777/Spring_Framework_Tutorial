package com.codeslayer.cruddemo.dao;

import com.codeslayer.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
}
