package com.practice.BarbecueManagementTool.models.response;

import com.practice.BarbecueManagementTool.models.Event;

public class DeleteEventServiceResponse {

	private Event event;

	public DeleteEventServiceResponse() {
		super();
	}

	public DeleteEventServiceResponse(Event event) {
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