package com.practice.BarbecueManagementTool.models.response;

import com.practice.BarbecueManagementTool.models.Event;

public class UpdateEventServiceResponse {

	private Event event;

	public UpdateEventServiceResponse() {
		super();
	}

	public UpdateEventServiceResponse(Event event) {
		super();
		this.event = event;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}
