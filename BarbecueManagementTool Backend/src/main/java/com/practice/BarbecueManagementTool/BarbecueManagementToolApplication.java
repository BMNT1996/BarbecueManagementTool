package com.practice.BarbecueManagementTool;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.practice.BarbecueManagementTool.models.ApplicationUser;
import com.practice.BarbecueManagementTool.models.Role;
import com.practice.BarbecueManagementTool.repository.RoleRepository;
import com.practice.BarbecueManagementTool.repository.UserRepository;

/**
 * 
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
@SpringBootApplication
public class BarbecueManagementToolApplication {
	public static void main(String[] args) {
		SpringApplication.run(BarbecueManagementToolApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository,
			PasswordEncoder passwordEncode) {
		return args -> {
			if (roleRepository.findByAuthority("ADMIN").isPresent())
				return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			ApplicationUser admin = new ApplicationUser(1, "admin", passwordEncode.encode("password"), roles);

			userRepository.save(admin);
		};
	}
}
