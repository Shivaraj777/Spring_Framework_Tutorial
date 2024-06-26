package org.codeslayer;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/*
    test classes are not public in general
    @Test annotation is used to create a unit test case(denotes a method as a unit test case)
    By default @BeforeAll and @AfterAll methods must be static
    @DisplayNameGeneration annotation is used to create custom test names automatically based on strategy
    @TestMethodOrder annotation is used to execute the test cases in a certain order based on the strategy provided
        -> MethodOrderer.OrderAnnotation.class -> executes the methods in order according number specified in @Order annotation -> lowest numbers have highest precedence -> negative numbers are allowed
        -> MethodOrderer.DisplayName.class -> executes the test methods in alphanumerical order of display names
*/
// @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @DisplayName("Jira-110_Test_Equals_and_NotEquals")
    @Order(1)
    void testEqualsAndNotEquals(){
        System.out.println("Running test: testEqualsAndNotEquals");
        assertEquals(6, demoUtils.add(2, 4), "2 + 4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1 + 9 must not be 6");
    }


    // unit test to check for multiplication of two numbers
    @Test
    @DisplayName("Jira-110_Test_Multiply")
    void testMultiply(){
        Assertions.assertEquals(10, demoUtils.multiply(2, 5), "2 * 5 must be 10");
        Assertions.assertNotEquals(7, demoUtils.multiply(2, 5), "2 * 5 must not be 7");
    }


    // unit test to check if an object is null/not null
    @Test
    @DisplayName("Jira-110_Test_Null_and_NotNull")
    @Order(-1)
    void testNullAndNotNull(){
        System.out.println("Running test: testNullAndNotNull");
        String s1 = null;
        String s2 = "hello";
        Assertions.assertNull(demoUtils.checkNull(s1), "Object should be null!");
        Assertions.assertNotNull(demoUtils.checkNull(s2), "Object should not be null");
    }


    // unit test to check whether object reference is same or not same
    @Test
    @DisplayName("Jira-110_Test_Same_and_Not_Same")
    @Order(6)
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


    // unit test to check whether array is equal
    @Test
    @DisplayName("Jira-110_Array_Equals")
    void testArrayEquals(){
        String[] stringArray = {"A", "B", "C"};
        Assertions.assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be the same");
    }


    // unit test to check if list is equal
    @Test
    @DisplayName("Jira-110_Iterable_Equals")
    void testIterableEquals(){
        List<String> theList = List.of("luv", "2", "code");
        Assertions.assertIterableEquals(theList, demoUtils.getAcademyInList(), "Expected list should be same as actual list");
    }


    // unit test to check if lines of a string match
    @Test
    @DisplayName("Jira-110_Lines_match")
    void testLinesMatch(){
        List<String> theList = List.of("luv", "2", "code");
        Assertions.assertLinesMatch(theList, demoUtils.getAcademyInList(), "Lines should match");
    }


    // unit test to check if a method throws an exception for values less than 0 and no exception for values greater than 0
    @Test
    @DisplayName("Jira-110_Throws_Exception")
    void testThrowsException(){
        Assertions.assertThrows(Exception.class, () -> {demoUtils.throwException(-1); }, "Should throw Exception for values less than 0");
        Assertions.assertDoesNotThrow(() -> {demoUtils.throwException(3); }, "Should not throw Exception for values greater than 0");
    }


    // unit test to check whether a method does not exceed a certain time
    @Test
    @DisplayName("Jira-110_TimeOut_Check")
    void testTimeout(){
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(3), () -> { demoUtils.checkTimeout(); }, "Method should execute in 3 seconds");
    }
}

