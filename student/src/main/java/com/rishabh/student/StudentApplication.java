package com.rishabh.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);

	}

	@Bean
	CommandLineRunner clr(StudentRepository studentRepository) {
		return args -> {
			Student rishabh = new Student(
					null,
					"Rishabh",
					"Singh",
					"rs23343@gmail.com",
					23);

			studentRepository.save(rishabh);
		};
	}

}
