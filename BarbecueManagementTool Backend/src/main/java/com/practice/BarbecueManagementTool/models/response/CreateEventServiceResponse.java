package com.practice.BarbecueManagementTool.models.response;

import com.practice.BarbecueManagementTool.models.Event;

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
