package com.codeslayer.tests;

import com.codeslayer.demo.DemoApplication;
import com.codeslayer.demo.dao.ApplicationDao;
import com.codeslayer.demo.models.CollegeStudent;
import com.codeslayer.demo.models.StudentGrades;
import com.codeslayer.demo.service.ApplicationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = DemoApplication.class)
public class MockAnnotationTests {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

    // @Mock annotation is used create a mock/test double to replace Application DAO
    @Mock
    private ApplicationDao applicationDao;

    // @InjectMocks annotation is used to inject mock dependency to ApplicationService(meaning ApplicationService will call test double of ApplicationDAO)
    // only injects dependencies which are annotated with @Mock or @Spy
    @InjectMocks
    private ApplicationService applicationService;


    @BeforeEach
    public void beforeEach(){
        studentOne.setFirstname("Rias");
        studentOne.setLastname("Grimory");
        studentOne.setEmailAddress("rias.grimory@codeslayer.com");
        studentOne.setStudentGrades(studentGrades);
    }


    // mock test to test ApplicationService using Mockito
    @Test
    @DisplayName("When and verify")
    public void assertEqualsTestAddGrades(){
        // setup expectations with mock response
        Mockito.when(applicationDao.addGradeResultsForSingleClass(studentGrades.getMathGradeResults())).thenReturn(100.00);

        // assert the expected result with ApplicationService response
        Assertions.assertEquals(100.00, applicationService.addGradeResultsForSingleClass(studentGrades.getMathGradeResults()));

        // verify whether expected ApplicationDAO method is called during test execution
        Mockito.verify(applicationDao).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());

        // verify how many times a ApplicationDAO method is executed during testing
        Mockito.verify(applicationDao, Mockito.times(1)).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());
    }
}
