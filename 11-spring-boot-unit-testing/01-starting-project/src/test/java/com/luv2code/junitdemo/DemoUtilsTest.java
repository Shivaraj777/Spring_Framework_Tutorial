package com.luv2code.junitdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/*
    test classes are not public in general
    @Test annotation is used to create a unit test case
*/
class DemoUtilsTest {

    // unit test to check if arithmetic result is equal/not-equal
    @Test
    void testEqualsAndNotEquals(){
        DemoUtils demoUtils = new DemoUtils();
        assertEquals(6, demoUtils.add(2, 4), "2 + 4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1 + 9 must not be 6");
    }


    // unit test to check if an object is null/not null
    @Test
    void testNullAndNotNull(){
        DemoUtils demoUtils = new DemoUtils();
        String s1 = null;
        String s2 = "hello";
        Assertions.assertNull(s1, "Object should be null!");
        Assertions.assertNotNull(s2, "Object should not be null");
    }
}
