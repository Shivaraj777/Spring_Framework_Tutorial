package com.codeslayer.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

// spring security configuration class
@Configuration
public class DemoSecurityConfig {

    // method to get user details from database using JDBC
    // dataSource is auto-injected by spring boot
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        // configure spring security to use JDBC authentication via dataSource
        JdbcUserDetailsManager theUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define the query to set spring security to use custom tables data
        theUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        theUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");

        return theUserDetailsManager;
    }

    // method to reference custom urls(web paths) for security(authentication)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/demo/").hasRole("EMPLOYEE")  // restrict url access to only EMPLOYEES
                        .requestMatchers("/demo/leaders/**").hasRole("MANAGER")  // restrict url access to only MANAGERS
                        .requestMatchers("/demo/systems/**").hasRole("ADMIN")  // restrict url access to only ADMINS
                        .anyRequest().authenticated()
            )
            .formLogin(form ->    // customize the form login process
                    form
                        .loginPage("/auth/showMyLoginPage")  // login page url
                        .loginProcessingUrl("/auth/authenticateTheUser")   // url to process the login form(this is automatically handled by spring and controller method is not required)
                        .permitAll()   // allow all users to see login page
            )
            .logout(logout -> logout.permitAll())   // add logout support -> default url: /logout
            .exceptionHandling(configurer ->
                    configurer.accessDeniedPage("/auth/access-denied")    // navigate to access denied page on exception
            );

        return http.build();
    }

    // method to create users in-memory
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
    //                .password(("{noop}test123"))
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
