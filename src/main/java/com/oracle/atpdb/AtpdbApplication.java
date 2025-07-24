package com.oracle.atpdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AtpdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtpdbApplication.class, args);
	}

}
