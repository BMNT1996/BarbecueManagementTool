package com.practice.BarbecueManagementTool.models.request;

import com.practice.BarbecueManagementTool.models.Event;

public class UpdateEventServiceRequest {

	private Event event;

	public UpdateEventServiceRequest() {
		super();
	}

	public UpdateEventServiceRequest(Event event) {
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
