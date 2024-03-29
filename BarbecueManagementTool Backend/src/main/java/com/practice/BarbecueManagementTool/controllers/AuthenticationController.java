package com.practice.BarbecueManagementTool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.BarbecueManagementTool.models.ApplicationUser;
import com.practice.BarbecueManagementTool.models.LoginResponseDTO;
import com.practice.BarbecueManagementTool.models.RegistrationDTO;
import com.practice.BarbecueManagementTool.services.AuthenticationService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/register")
	public ApplicationUser registerUser(@RequestBody RegistrationDTO body) {
		System.out.println("RegisterUser started");
		System.out.println(body);
		return authenticationService.registerUser(body.getUsername(), body.getPassword());
	}

	@PostMapping("/login")
	public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body) {
		System.out.println("RegisterUser started");
		System.out.println(body);
		return authenticationService.loginUser(body.getUsername(), body.getPassword());
	}
}
