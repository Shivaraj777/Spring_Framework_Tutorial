package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;


/*
    @Disabled annotation denotes that test method should not be executed
    @EnabledOnOs annotation is used to execute tests on specified Operating systems
    @EnabledOnJre annotation is sued to execute tests on specified versions of JDK/JRE
    @EnabledForJreRange annotation is used to execute tests if JRE version lies between a specified range
    @EnabledIfSystemProperty annotation is used to execute tests if a certain system property is present in test configuration
    @EnabledIfEnvironmentVariable annotation is used to execute tests if a certain environment variable is present in test configuration
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


    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void testForJRE17Only(){
        // execute method and perform asserts
    }


    @Test
    @EnabledOnJre(JRE.JAVA_21)
    void testForJRE21Only(){
        // execute method and perform asserts
    }


    @Test
    @EnabledOnJre({ JRE.JAVA_17, JRE.JAVA_21})
    void testForJRE17and21(){
        // execute method and perform asserts
    }


    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_17)
    void testForJRERange1(){
        // execute method and perform asserts
    }


    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_21)
    void testForJRERange2(){
        // execute method and perform asserts
    }


    @Test
    @EnabledIfSystemProperty(named = "TEST_SYS_PROP", matches = "CI_CD_DEPLOY")
    void testForSystemProperty(){
        // execute method and perform asserts
    }


    @Test
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "DEV")
    void testForEnvironmentVariable(){
        // execute method and perform asserts
    }
}
