package com.codeslayer.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// spring security configuration class
@Configuration
public class DemoSecurityConfig {

    // method to create users in-memory
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                .username("John")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("Mary")
                .password(("{noop}test123"))
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("Susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }


    // method to reference custom urls(web paths) for security(authentication)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .anyRequest().authenticated()
            )
            .formLogin(form ->    // customize the form login process
                    form
                        .loginPage("/auth/showMyLoginPage")  // login page url
                        .loginProcessingUrl("/auth/authenticateTheUser")   // url to process the login form(this is automatically handled by spring and controller method is not required)
                        .permitAll()   // allow all users to see login page
            );

        return http.build();
    }
}
