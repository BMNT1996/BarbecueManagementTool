package com.practice.BarbecueManagementTool.models.response;

import java.util.List;

import com.practice.BarbecueManagementTool.models.Event;

/**
 * Response model for GetAllEvents Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
public class GetAllEventsServiceResponse {

	List<Event> events;

	public GetAllEventsServiceResponse() {
		super();
	}

	public GetAllEventsServiceResponse(List<Event> events) {
		this.events = events;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
