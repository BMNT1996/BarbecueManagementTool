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
import com.practice.BarbecueManagementTool.models.request.GetDashboardInformationServiceRequest;
import com.practice.BarbecueManagementTool.models.request.GetEventByCodeServiceRequest;
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
		System.out.println("GetAllEvents started");
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
					.writeValueAsString(eventService.getAllEvents());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	@PostMapping("/create")
	public String CreateEvent(@RequestBody CreateEventServiceRequest request) {
		System.out.println("CreateEvent started");
		System.out.println(ObjectToJsonString(request));
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
					.writeValueAsString(eventService.createEvent(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	@PostMapping("/update")
	public String UpdateEvent(@RequestBody UpdateEventServiceRequest request) {
		System.out.println("UpdateEvent started");
		System.out.println(ObjectToJsonString(request));
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
					.writeValueAsString(eventService.updateEvent(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	@PostMapping("/delete")
	public String DeleteEvent(@RequestBody DeleteEventServiceRequest request) {
		System.out.println("DeleteEvent started");
		System.out.println(ObjectToJsonString(request));
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
					.writeValueAsString(eventService.deleteEvent(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error 500";
		}
	}
	
	@PostMapping("/getdashboardinformation")
	public String GetDashBoardInformation(@RequestBody GetDashboardInformationServiceRequest request) {
		System.out.println("GetDashBoardInformation started");
		System.out.println(ObjectToJsonString(request));
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
					.writeValueAsString(eventService.getDashboardInformation(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error 500";
		}
	}
	
	@PostMapping("/geteventbycode")
	public String GetEventByCode(@RequestBody GetEventByCodeServiceRequest request) {
		System.out.println("GetEventByCode started");
		System.out.println(ObjectToJsonString(request));
		try {
			System.out.println(ObjectToJsonString(request));
			return ObjectToJsonString(eventService.GetEventByCode(request));
		} catch (Exception e) {
			e.printStackTrace();
			return "error 500";
		}
	}
	
	private String ObjectToJsonString(Object obj) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
			.writeValueAsString(obj).toString();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
		
	}

}
