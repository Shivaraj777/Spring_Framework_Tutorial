package com.codeslayer.test;

import com.codeslayer.demo.DemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
    if the Test class is in a different package from main application class,
    then we need to specify the name of the main application class for tests should be executed
*/
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests2 {

    @Test
    void demoTest(){

    }
}
