package com.codeslayer.springCoreDemo.config;

import com.codeslayer.springCoreDemo.common.Coach;
import com.codeslayer.springCoreDemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration annotation is used to create a Configuration class
@Configuration
public class SportConfig {

    // @Bean annotation is used to create a bean for an external class without using @Component annotation
    // BeanId will be the name of the method by default.
    // the method will return the instance of the bean class
    @Bean("aquatic") // @Bean("bean_id") ---> define the beanId
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
