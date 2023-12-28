package com.practice.BarbecueManagementTool.models.request;

import com.practice.BarbecueManagementTool.models.Event;

public class DeleteEventServiceRequest {

	private Event event;

	public DeleteEventServiceRequest() {
		super();
	}

	public DeleteEventServiceRequest(Event event) {
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
