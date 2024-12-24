package com.campusdual.amazing_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
		SpringApplication.run(AmazingStore.class, args);}
//		SpringApplication.run(AmazingStore.class, args);
//
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//		String rawPasswordUser = "user123";
//		String rawPasswordAdmin = "admin123";
//
//		String hashedUserPassword = passwordEncoder.encode(rawPasswordUser);
//		String hashedAdminPassword = passwordEncoder.encode(rawPasswordAdmin);
//
//		System.out.println("Hashed User Password: " + hashedUserPassword);
//		System.out.println("Hashed Admin Password: " + hashedAdminPassword);
//	}
}
