package com.practice.BarbecueManagementTool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.BarbecueManagementTool.models.request.CreateEventServiceRequest;
import com.practice.BarbecueManagementTool.models.request.DeleteEventServiceRequest;
import com.practice.BarbecueManagementTool.models.request.GetDashboardInformationServiceRequest;
import com.practice.BarbecueManagementTool.models.request.GetEventByCodeServiceRequest;
import com.practice.BarbecueManagementTool.models.request.GetEventPeopleAndProductsByEventCodeServiceRequest;
import com.practice.BarbecueManagementTool.models.request.UpdateEventServiceRequest;
import com.practice.BarbecueManagementTool.services.EventService;

/**
 * Class with the controller for the Events
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
@RestController
@RequestMapping("/event")
@CrossOrigin("*")
public class EventController {

	@Autowired
	private EventService eventService;

	/**
	 * Method to get all the events in the database
	 * 
	 * @return Response model as Json String with the list of all events
	 */
	@GetMapping("/")
	public String getAllEvents() {
		System.out.println("GetAllEvents started");
		try {
			return ControllerUtils.objectToJsonString(eventService.getAllEvents());
		} catch (Exception e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	/**
	 * Method to create a new event in the database, this includes the creation of the event
	 * and the necessary junctions.
	 * 
	 * @param request Request model with the event and owner information
	 * @return Response model as Json String with the event created
	 */
	@PostMapping("/create")
	public String createEvent(@RequestBody CreateEventServiceRequest request) {
		System.out.println("CreateEvent started");
		System.out.println(ControllerUtils.objectToJsonString(request));
		try {
			return ControllerUtils.objectToJsonString(eventService.createEvent(request));
		} catch (Exception e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	/**
	 * Method to update an existent event in the database.
	 * 
	 * @param request Request model with the event updated
	 * @return Response model as Json String with the event updated confirmation
	 */
	@PostMapping("/update")
	public String updateEvent(@RequestBody UpdateEventServiceRequest request) {
		System.out.println("UpdateEvent started");
		System.out.println(ControllerUtils.objectToJsonString(request));
		try {
			return ControllerUtils.objectToJsonString(eventService.updateEvent(request));
		} catch (Exception e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	/**
	 * Method to delete an existent event in the database
	 * 
	 * @param request Request model with the event to be deleted
	 * @return Response model as Json String with the event that was deleted
	 */
	@PostMapping("/delete")
	public String deleteEvent(@RequestBody DeleteEventServiceRequest request) {
		System.out.println("DeleteEvent started");
		System.out.println(ControllerUtils.objectToJsonString(request));
		try {
			return ControllerUtils.objectToJsonString(eventService.deleteEvent(request));
		} catch (Exception e) {
			e.printStackTrace();
			return "error 500";
		}
	}
	
	/**
	 * Method to get all the necessary information for the dashboard view
	 * 
	 * @param request Request model with the username of the user that is requesting his dashboard information
	 * @return Response model as Json String with all the necessary data
	 */
	@PostMapping("/getdashboardinformation")
	public String getDashBoardInformation(@RequestBody GetDashboardInformationServiceRequest request) {
		System.out.println("GetDashBoardInformation started");
		System.out.println(ControllerUtils.objectToJsonString(request));
		try {
			return ControllerUtils.objectToJsonString(eventService.getDashboardInformation(request));
		} catch (Exception e) {
			e.printStackTrace();
			return "error 500";
		}
	}
	
	/**
	 * Method that get an event by its code
	 * 
	 * @param request Request model with the code of the event requested
	 * @return Response model as Json String with the event that correspond to the code of the request
	 */
	@PostMapping("/geteventbycode")
	public String getEventByCode(@RequestBody GetEventByCodeServiceRequest request) {
		System.out.println("GetEventByCode started");
		System.out.println(ControllerUtils.objectToJsonString(request));
		try {
			return ControllerUtils.objectToJsonString(eventService.GetEventByCode(request));
		} catch (Exception e) {
			e.printStackTrace();
			return "error 500";
		}
	}
	
	/**
	 * Method that gets all the information about people and products of an event by its event code
	 * 
	 * @param request Request model with the code of the event
	 * @return Response model as Json String with the information of the people and products of the service
	 */
	@PostMapping("/geteventpeopleandproductsbyeventcode")
	public String getEventPeopleAndProductsByEventCode(@RequestBody GetEventPeopleAndProductsByEventCodeServiceRequest request) {
		System.out.println("GetEventPeopleAndProductsByEventCode started");
		System.out.println(ControllerUtils.objectToJsonString(request));
		try {
			return ControllerUtils.objectToJsonString(eventService.GetEventPeopleAndProductsByEventCode(request));
		} catch (Exception e) {
			e.printStackTrace();
			return "error 500";
		}
	}

}
