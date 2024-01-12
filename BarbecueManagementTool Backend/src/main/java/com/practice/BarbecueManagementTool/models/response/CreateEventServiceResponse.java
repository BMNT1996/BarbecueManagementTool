package com.practice.BarbecueManagementTool.models.response;

import com.practice.BarbecueManagementTool.models.Event;

/**
 * Response model for CreateEvent Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
public class CreateEventServiceResponse {

	Event event;

	public CreateEventServiceResponse() {
		super();
	}

	public CreateEventServiceResponse(Event event) {
		this.event = event;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}
