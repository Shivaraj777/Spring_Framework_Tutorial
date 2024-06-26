package org.codeslayer.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


/*
    @ParameterizedTest annotation is used to create a parameterized unit test
        name = "value={0}, expected={1}"    value and expected are test parameters from csv file
    @CsvFileSource annotation is used read test parameters from csv file
*/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FizzBuzzTest {
    // If number is divisible by 3, print Fizz
    // If number is divisible by 5, print Buzz
    // If number is divisible by 3 and 5, print FizzBuzz
    // If number is not divisible by 3 or 5, then print the number

    @Test
    @DisplayName("Divisible by Three")
    @Order(1)
    void testForDivisibleByThree(){
        // Assertions.fail("Fail");  // assertion to fail the test by default
        String expected = "Fizz";
        Assertions.assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
    }


    @Test
    @DisplayName("Divisible by Five")
    @Order(2)
    void testForDivisibleByFive(){
        String expected = "Buzz";
        Assertions.assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");
    }


    @Test
    @DisplayName("Divisible by Three & Five")
    @Order(3)
    void testForDivisibleByThreeAndFive(){
        String expected = "FizzBuzz";
        Assertions.assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");
    }


    @Test
    @DisplayName("Not Divisible by Three & Five")
    @Order(4)
    void testForNotDivisibleByThreeAndFive(){
        String expected = "2";
        Assertions.assertEquals(expected, FizzBuzz.compute(2), "Should return 2");
    }


    // unit test to execute Fizz Buzz logic for different test sets
    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    @DisplayName("Testing with small data file")
    @Order(5)
    void testSmallDataFile(int value, String expected){
        Assertions.assertEquals(expected, FizzBuzz.compute(value), "Result should match expected");
    }
}
