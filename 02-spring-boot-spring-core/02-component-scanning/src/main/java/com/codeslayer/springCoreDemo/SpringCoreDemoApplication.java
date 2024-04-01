package com.codeslayer.springCoreDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		// list the packages for component scan
		scanBasePackages = { "com.codeslayer.springCoreDemo",
							 "com.codeslayer.util"
		}
)
public class SpringCoreDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreDemoApplication.class, args);
	}

}
