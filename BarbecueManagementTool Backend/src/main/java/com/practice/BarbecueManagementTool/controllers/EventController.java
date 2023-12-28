package com.practice.BarbecueManagementTool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import com.practice.BarbecueManagementTool.models.request.AddParticipantServiceRequest;
import com.practice.BarbecueManagementTool.models.request.CreateEventServiceRequest;
import com.practice.BarbecueManagementTool.models.request.DeleteEventServiceRequest;
//import com.practice.BarbecueManagementTool.models.request.DeleteParticipantServiceRequest;
import com.practice.BarbecueManagementTool.models.request.UpdateEventServiceRequest;
//import com.practice.BarbecueManagementTool.models.request.UpdateParticipantServiceRequest;
import com.practice.BarbecueManagementTool.services.EventService;

@RestController
@RequestMapping("/event")
@CrossOrigin("*")
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping("/")
	public String GetAllEvents() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
					.writeValueAsString(eventService.GetAllEvents());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	@PostMapping("/create")
	public String CreateEvent(@RequestBody CreateEventServiceRequest request) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
					.writeValueAsString(eventService.CreateEvent(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	@PostMapping("/update")
	public String UpdateEvent(@RequestBody UpdateEventServiceRequest request) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
					.writeValueAsString(eventService.UpdateEvent(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	@PostMapping("/delete")
	public String DeleteEvent(@RequestBody DeleteEventServiceRequest request) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
					.writeValueAsString(eventService.DeleteEvent(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error 500";
		}
	}

}
