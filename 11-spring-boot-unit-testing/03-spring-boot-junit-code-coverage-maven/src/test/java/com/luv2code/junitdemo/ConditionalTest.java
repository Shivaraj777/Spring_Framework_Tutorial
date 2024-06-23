package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


/*
    @Disabled annotation denotes that test method should not be executed
    @EnabledOnOS annotation is used to execute tests on specified Operating systems
*/
public class ConditionalTest {

    @Test
    @Disabled("Don't execute this test until Jira-123 is resolved")
    void basicTest(){
        // execute method and perform asserts
    }


    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindowsOnly(){
        // execute method and perform asserts
    }


    @Test
    @EnabledOnOs(OS.MAC)
    void testForMacOnly(){
        // execute method and perform asserts
    }


    @Test
    @EnabledOnOs(OS.LINUX)
    void testForLinuxOnly(){
        // execute method and perform asserts
    }


    @Test
    @EnabledOnOs({ OS.WINDOWS, OS.MAC })
    void testForMacAndWindowsOnly(){
        // execute method and perform asserts
    }
}
