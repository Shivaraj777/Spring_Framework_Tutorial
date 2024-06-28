package com.codeslayer.tests;

import com.codeslayer.demo.DemoApplication;
import com.codeslayer.demo.models.CollegeStudent;
import com.codeslayer.demo.models.StudentGrades;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

/*
    if the Test class is in a different package from main application class,
    then we need to specify the name of the main application class for tests should be executed
*/
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests2 {

    private static int count = 0;

    @Value("${info.app.name}")
    private String appInfo;

    @Value("${info.app.description}")
    private String appDescription;

    @Value("${info.app.version}")
    private String appVersion;

    @Value("${info.school.name}")
    private String schoolName;

    @Autowired
    CollegeStudent student;

    @Autowired
    StudentGrades studentGrades;

    @Autowired
    ApplicationContext context;


    @BeforeEach
    public void beforeEach(){
        count++;
        System.out.println("Testing: " + appInfo + " which is " + appDescription + " Version: " + appVersion + ". Execution of test method " + count);
        student.setFirstname("Erica");
        student.setLastname("Cantona");
        student.setEmailAddress("erica.cantona@codeslayer.com");
        studentGrades.setMathGradeResults(new ArrayList<>(Arrays.asList(100.0, 85.0, 76.50, 91.75)));
        student.setStudentGrades(studentGrades);
    }


    @Test
    void demoTest(){

    }


    @Test
    @DisplayName("Adding_Grade_results_for_student_grades")
    public void addGradeResultsForStudentGrades(){
        Assertions.assertEquals(353.25, studentGrades.addGradeResultsForSingleClass(student.getStudentGrades().getMathGradeResults()), "The total Math grade of Student should be 353.25");
    }


    @Test
    @DisplayName("Adding_Grade_results_for_student_grades_Not_Equal")
    public void addGradeResultsForStudentGradesNotEqual(){
        Assertions.assertNotEquals(400.00, studentGrades.addGradeResultsForSingleClass(student.getStudentGrades().getMathGradeResults()), "The total Math grade of Student should not be 400.00");
    }


    @Test
    @DisplayName("Is_Grade_greater")
    public void isGradeGreaterStudentGrades(){
        Assertions.assertTrue(studentGrades.isGradeGreater(90, 75), "failure - should be true");
    }


    @Test
    @DisplayName("Is_Grade_greater_false")
    public void isGradeGreaterStudentGradesAssertFalse(){
        Assertions.assertFalse(studentGrades.isGradeGreater(45, 75), "failure - should be false");
    }


    @Test
    @DisplayName("Check_Null_for_student_grades")
    public void checkNullForStudentGrades(){
        Assertions.assertNotNull(studentGrades.checkNull(student.getStudentGrades().getMathGradeResults()), "Object should not be null");
    }


    @Test
    @DisplayName("Create_students_without_grades_init")
    public void createStudentsWithoutGradesInit(){
        // create a CollegeStudent bean/object with the help of application context
        CollegeStudent studentTwo = context.getBean("collegeStudent", CollegeStudent.class);
        studentTwo.setFirstname("Diana");
        studentTwo.setLastname("Penty");
        studentTwo.setEmailAddress("diana.penty@codeslayer.com");
        Assertions.assertNotNull(studentTwo.getFirstname());
        Assertions.assertNotNull(studentTwo.getLastname());
        Assertions.assertNotNull(studentTwo.getEmailAddress());
        Assertions.assertNull(studentGrades.checkNull(studentTwo.getStudentGrades()));
    }


    @Test
    @DisplayName("Verify_students_are_prototypes")
    public void verifyStudentsArePrototypes(){
        CollegeStudent studentTwo = context.getBean("collegeStudent", CollegeStudent.class);
        Assertions.assertNotSame(student, studentTwo, "Student and studentTwo should not be same");
    }


    @Test
    @DisplayName("Find_Grade_Point_Average")
    public void findGradePointAverage(){
        Assertions.assertAll("Testing all assertEquals",
                () -> Assertions.assertEquals(353.25, studentGrades.addGradeResultsForSingleClass(
                        student.getStudentGrades().getMathGradeResults())),
                () -> Assertions.assertEquals(88.31, studentGrades.findGradePointAverage(
                        student.getStudentGrades().getMathGradeResults())
                )
        );
    }
}
