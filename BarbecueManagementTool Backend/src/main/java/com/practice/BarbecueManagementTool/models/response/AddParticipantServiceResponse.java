package com.practice.BarbecueManagementTool.models.response;

import com.practice.BarbecueManagementTool.models.EventUserJunction;

public class AddParticipantServiceResponse {

	private EventUserJunction eventUserJunction;

	public AddParticipantServiceResponse() {
		super();
	}

	public AddParticipantServiceResponse(EventUserJunction eventUserJunction) {
		super();
		this.eventUserJunction = eventUserJunction;
	}

	public EventUserJunction getEventUserJunction() {
		return eventUserJunction;
	}

	public void setEventUserJunction(EventUserJunction eventUserJunction) {
		this.eventUserJunction = eventUserJunction;
	}

}
