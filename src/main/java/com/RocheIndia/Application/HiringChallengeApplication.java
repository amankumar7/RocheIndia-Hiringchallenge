package com.RocheIndia.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.RocheIndia")
public class HiringChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiringChallengeApplication.class, args);
	}

}
