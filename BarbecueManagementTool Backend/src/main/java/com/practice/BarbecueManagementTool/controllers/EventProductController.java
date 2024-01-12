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

/**
 * Class with the controller for the EventProductJunction
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
@RestController
@RequestMapping("/eventproduct")
@CrossOrigin("*")
public class EventProductController {

	@Autowired
	private EventProductJunctionService eventProductJunctionService;

	/**
	 * Method to add a new junction between Event and Product
	 * 
	 * @param request Request model with the junction information
	 * @return Response model as JsonString of the junction created
	 */
	@PostMapping("/add")
	public String addEventProduct(@RequestBody AddEventProductServiceRequest request) {
		try {
			return ControllerUtils.objectToJsonString(eventProductJunctionService.addEventProduct(request));
		} catch (Exception e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	/**
	 * Method to update an existent junction between Event and Product in the database
	 * 
	 * @param request Request model with the junction updated
	 * @return Response model with the junction updated confirmed
	 */
	@PostMapping("/update")
	public String updateEventProduct(@RequestBody UpdateEventProductServiceRequest request) {
		try {
			return ControllerUtils.objectToJsonString(eventProductJunctionService.updateEventProduct(request));
		} catch (Exception e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	/**
	 * Method to delete an existent junction between Event and Product in the database
	 * 
	 * @param request Request model with the junction between Event and Product to be deleted
	 * @return Response model as Json String with the junction between Event and Product that was deleted
	 */
	@PostMapping("/delete")
	public String deleteEventProduct(@RequestBody DeleteEventProductServiceRequest request) {
		try {
			return ControllerUtils.objectToJsonString(eventProductJunctionService.deleteEventProduct(request));
		} catch (Exception e) {
			e.printStackTrace();
			return "error 500";
		}
	}

}
