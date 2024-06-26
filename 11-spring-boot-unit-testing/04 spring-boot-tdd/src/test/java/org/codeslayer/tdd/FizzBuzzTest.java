package org.codeslayer.tdd;

import org.junit.jupiter.api.*;

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
        Assertions.fail("Fail");  // assertion to fail the test by default
    }
}
