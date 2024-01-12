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

/**
 * Class with the controller for the EventUserJunction
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
@RestController
@RequestMapping("/participation")
@CrossOrigin("*")
public class ParticipationController {

	@Autowired
	private EventUserJunctionService eventUserJunctionService;

	/**
	 * Method to add a new junction between Event and User
	 * 
	 * @param request Request model with the junction information
	 * @return Response model as JsonString of the junction created
	 */
	@PostMapping("/add")
	public String addParticipant(@RequestBody AddParticipantServiceRequest request) {
		try {
			return ControllerUtils.objectToJsonString(eventUserJunctionService.addParticipant(request));
		} catch (Exception e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	/**
	 * Method to update an existent junction between Event and User in the database
	 * 
	 * @param request Request model with the junction updated
	 * @return Response model with the junction updated confirmed
	 */
	@PostMapping("/update")
	public String updateParticipant(@RequestBody UpdateParticipantServiceRequest request) {
		try {
			return ControllerUtils.objectToJsonString(eventUserJunctionService.updateParticipant(request));
		} catch (Exception e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	/**
	 * Method to delete an existent junction between Event and User in the database
	 * 
	 * @param request Request model with the junction between Event and User to be deleted
	 * @return Response model as Json String with the junction between Event and User that was deleted
	 */
	@PostMapping("/delete")
	public String deleteParticipant(@RequestBody DeleteParticipantServiceRequest request) {
		try {
			return ControllerUtils.objectToJsonString(eventUserJunctionService.deleteParticipant(request));
		} catch (Exception e) {
			e.printStackTrace();
			return "error 500";
		}
	}

}
