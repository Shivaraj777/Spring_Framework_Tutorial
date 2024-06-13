package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/*
    test classes are not public in general
    @Test annotation is used to create a unit test case
    By default @BeforeAll and @AfterAll methods must be static
*/
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
}
