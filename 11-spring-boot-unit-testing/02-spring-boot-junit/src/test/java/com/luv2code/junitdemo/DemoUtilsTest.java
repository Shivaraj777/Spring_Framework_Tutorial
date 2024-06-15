package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/*
    test classes are not public in general
    @Test annotation is used to create a unit test case
    By default @BeforeAll and @AfterAll methods must be static
    @DisplayNameGeneration annotation is used to create custom test names automatically based on strategy
*/
// @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeAll
    static void setupBeforeAll(){
        System.out.println("@BeforeAll executes only once before all test methods");
    }

    
    @BeforeEach
    void setupBeforeEach(){
        demoUtils = new DemoUtils();
        System.out.println("\n@BeforeEach executes before the execution of each method");
    }


    @AfterAll
    static void setupAfterAll(){
        System.out.println("\n@AfterAll executes only once after all test methods");
    }


    @AfterEach
    void tearDownAfterEach(){
        System.out.println("@AfterEach executes after the execution of each method");
    }


    // unit test to check if arithmetic result is equal/not-equal
    // @DisplayName annotation is used to provide a custom name to test case(displayed after execution)
    @Test
    @DisplayName("Jira-110_Test_Null_and_Not_Null")
    void testEqualsAndNotEquals(){
        System.out.println("Running test: testEqualsAndNotEquals");
        assertEquals(6, demoUtils.add(2, 4), "2 + 4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1 + 9 must not be 6");
    }


    // unit test to check if an object is null/not null
    @Test
    @DisplayName("Jira-110_Test_Equals_and_Not_Equals")
    void testNullAndNotNull(){
        System.out.println("Running test: testNullAndNotNull");
        String s1 = null;
        String s2 = "hello";
        Assertions.assertNull(s1, "Object should be null!");
        Assertions.assertNotNull(s2, "Object should not be null");
    }


    // unit test to check whether object reference is same or not same
    @Test
    @DisplayName("Jira-110_Test_Same_and_Not_Same")
    void testSameAndNotSame(){
        String str = "luv2code";
        Assertions.assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Object should refer to the same object");
        Assertions.assertNotSame(str, demoUtils.getAcademy(), "Object should not refer to the same object");
    }


    // unit test to check whether number is grater than other
    @Test
    @DisplayName("Jira-110_Test_True_and_False")
    void testTrueAndFalse(){
        int gradeOne = 10;
        int gradeTwo = 5;
        Assertions.assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
        Assertions.assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");

    }
}
