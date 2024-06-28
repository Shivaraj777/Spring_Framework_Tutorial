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
import org.springframework.boot.test.mock.mockito.MockBean;
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
    // @Mock
    // private ApplicationDao applicationDao;

    // @InjectMocks annotation is used to inject mock dependency to ApplicationService(meaning ApplicationService will call test double of ApplicationDAO)
    // only injects dependencies which are annotated with @Mock or @Spy
    // @InjectMocks
    // private ApplicationService applicationService;

    // @MockBean annotation is used to create a test double to replace Application DAO
    // it also adds the bean to the spring application context and hence the dependency can be injected by using @Autowired
    // using @MockBean we can inject both mock and normal dependencies
    @MockBean
    private ApplicationDao applicationDao;

    @Autowired
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


    // mock test
    @Test
    @DisplayName("Find GPA")
    public void assetEqualsTestFindGPA(){
        Mockito.when(applicationDao.findGradePointAverage(studentGrades.getMathGradeResults())).thenReturn(88.31);
        Assertions.assertEquals(88.31, applicationService.findGradePointAverage(studentGrades.getMathGradeResults()));
    }


    @Test
    @DisplayName("Not Null")
    public void testAssertNotNull(){
        Mockito.when(applicationDao.checkNull(studentGrades.getMathGradeResults())).thenReturn(true);
        Assertions.assertNotNull(applicationService.checkNull(studentGrades.getMathGradeResults()), "Object should not be null");
    }
}
