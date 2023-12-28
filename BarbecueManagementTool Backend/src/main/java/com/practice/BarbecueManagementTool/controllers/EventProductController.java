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
import com.practice.BarbecueManagementTool.models.request.AddEventProductServiceRequest;
import com.practice.BarbecueManagementTool.models.request.DeleteEventProductServiceRequest;
import com.practice.BarbecueManagementTool.models.request.UpdateEventProductServiceRequest;
import com.practice.BarbecueManagementTool.services.EventProductJunctionService;

@RestController
@RequestMapping("/eventproduct")
@CrossOrigin("*")
public class EventProductController {

	@Autowired
	private EventProductJunctionService eventProductJunctionService;

	@PostMapping("/add")
	public String AddEventProduct(@RequestBody AddEventProductServiceRequest request) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
					.writeValueAsString(eventProductJunctionService.AddEventProduct(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	@PostMapping("/update")
	public String UpdateEventProduct(@RequestBody UpdateEventProductServiceRequest request) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
					.writeValueAsString(eventProductJunctionService.UpdateEventProduct(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	@PostMapping("/delete")
	public String DeleteEventProduct(@RequestBody DeleteEventProductServiceRequest request) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
					.writeValueAsString(eventProductJunctionService.DeleteEventProduct(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error 500";
		}
	}

}
