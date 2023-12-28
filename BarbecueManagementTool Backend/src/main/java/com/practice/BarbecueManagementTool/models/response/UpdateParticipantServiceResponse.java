package com.practice.BarbecueManagementTool.models.response;

import com.practice.BarbecueManagementTool.models.EventUserJunction;

public class UpdateParticipantServiceResponse {

	private EventUserJunction eventUserJunction;

	public UpdateParticipantServiceResponse() {
		super();
	}

	public UpdateParticipantServiceResponse(EventUserJunction eventUserJunction) {
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
