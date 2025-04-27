package com.prshkv.backendproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.prshkv.backendproject.domain.AppUser;
import com.prshkv.backendproject.domain.AppUserRepository;

@SpringBootApplication
public class BackendprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendprojectApplication.class, args);

	}

	@Bean
	public CommandLineRunner cml(AppUserRepository appUserRepository) {
		return (args) -> {
			
			AppUser testAdmin = new AppUser();
			testAdmin.setPasswordHash("$2a$10$4JNnAuMep5O5UBnJq9JrVOrR.6BnrAlbYmS2kKYohnP6vFvlO7Bp.");
			testAdmin.setEmail("admin@email.com");
			testAdmin.setRole("ROLE_ADMIN");
			testAdmin.setUsername("admin");

			appUserRepository.save(testAdmin);

		};
	}

}