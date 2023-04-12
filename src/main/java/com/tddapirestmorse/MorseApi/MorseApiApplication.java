package com.tddapirestmorse.MorseApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.tddapirestmorse.MorseApi.*")
public class MorseApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(MorseApiApplication.class, args);
	}

}
