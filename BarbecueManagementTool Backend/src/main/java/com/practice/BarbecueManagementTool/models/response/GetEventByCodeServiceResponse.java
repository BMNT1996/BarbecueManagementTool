package com.practice.BarbecueManagementTool.models.response;

import com.practice.BarbecueManagementTool.models.Event;

public class GetEventByCodeServiceResponse {

	private Event event;

	public GetEventByCodeServiceResponse() {
		super();
	}

	public GetEventByCodeServiceResponse(Event event) {
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
