package com.prshkv.backendproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.prshkv.backendproject.domain.AppUserRepository;
import com.prshkv.backendproject.domain.ExploitRepository;
import com.prshkv.backendproject.domain.ExploitTypeRepository;
import com.prshkv.backendproject.domain.PlatformRepository;

@SpringBootApplication
public class BackendprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendprojectApplication.class, args);

	}

	@Bean
	public CommandLineRunner cml(AppUserRepository appUserRepository, ExploitRepository exploitRepository, ExploitTypeRepository exploitTypeRepository, PlatformRepository platformRepository) {
		return (args) -> {
			
			
			platformRepository.deleteAll();

		};
	}

}