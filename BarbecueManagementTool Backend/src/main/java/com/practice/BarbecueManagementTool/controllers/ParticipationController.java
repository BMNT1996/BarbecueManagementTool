package com.practice.BarbecueManagementTool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.practice.BarbecueManagementTool.models.request.AddParticipantServiceRequest;
import com.practice.BarbecueManagementTool.models.request.DeleteParticipantServiceRequest;
import com.practice.BarbecueManagementTool.models.request.UpdateParticipantServiceRequest;
import com.practice.BarbecueManagementTool.services.EventUserJunctionService;

@RestController
@RequestMapping("/participation")
@CrossOrigin("*")
public class ParticipationController {

	@Autowired
	private EventUserJunctionService eventUserJunctionService;

	@PostMapping("/add")
	public String AddParticipant(@RequestBody AddParticipantServiceRequest request) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
					.writeValueAsString(eventUserJunctionService.AddParticipant(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	@PostMapping("/update")
	public String UpdateParticipant(@RequestBody UpdateParticipantServiceRequest request) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
					.writeValueAsString(eventUserJunctionService.UpdateParticipant(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	@PostMapping("/delete")
	public String DeleteParticipant(@RequestBody DeleteParticipantServiceRequest request) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
					.writeValueAsString(eventUserJunctionService.DeleteParticipant(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error 500";
		}
	}

}
