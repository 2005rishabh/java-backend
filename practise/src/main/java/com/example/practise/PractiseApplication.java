package com.example.practise;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class PractiseApplication {

	public static void main(String[] args) {
		Path workingDir = Paths.get(System.getProperty("user.dir"));
		Path dotenvDir = workingDir;
		if (!Files.exists(dotenvDir.resolve(".env"))) {
			Path candidate = workingDir.resolve("practise");
			if (Files.exists(candidate.resolve(".env"))) {
				dotenvDir = candidate;
			}
		}

		Dotenv dotenv = Dotenv.configure()
				.directory(dotenvDir.toString())
				.ignoreIfMissing()
				.load();

		dotenv.entries().forEach((entry) -> {
			System.setProperty(entry.getKey(), entry.getValue());
		});

		SpringApplication.run(PractiseApplication.class, args);
	}

}
