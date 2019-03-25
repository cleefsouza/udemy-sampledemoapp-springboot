package com.udemy.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SampleDemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleDemoAppApplication.class, args);
	}

}
