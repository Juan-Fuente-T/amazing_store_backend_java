package com.campusdual.amazing_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Main entry point for the {@code AmazingStore} application.
 * This class initializes the Spring Boot application context and starts the application.
 * It serves as the starting point for running the application.
 */
@SpringBootApplication
//@SpringBootApplication(scanBasePackages = "com.campusdual")

public class AmazingStore {
	/**
	 * Entry point method that bootstraps the Spring Boot application.
	 * This method executes the application context and launches the application lifecycle.
	 * It is necessary to close any running instances of the application
	 * beforehand to avoid port conflicts.
	 *
	 * @param args Command line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(AmazingStore.class, args);
	}

}
