package com.codeslayer.springboot.cruddemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

// Spring Security configuration
@Configuration
public class DemoSecurityConfig {

    // get user details from database using jdbc...
    @Bean
    @Autowired
    public UserDetailsManager userDetailsManager(DataSource dataSource){  // dataSource is auto-injected by spring boot
        // configure spring security to use JDBC authentication via dataSource
        return new JdbcUserDetailsManager(dataSource);
    }


    // configuration to restrict access to users based on roles
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        // the apis will be accessible to users with mentioned role in requestMatchers
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        // configure to use http basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable cross site request forgery(CSRF) --> enabled for browser web applications, disabled for stateless  REST APIs
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }


//    // configuration to create and store user details in memory
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails john = User.builder()
//                .username("John")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails mary = User.builder()
//                .username("Mary")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//        UserDetails susan = User.builder()
//                .username("Susan")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john, mary, susan);
//    }

}

/*
    since we have defined application users in this configuration...
    spring boot will not user the username and password from the application.properties file
 */
