package com.practice.BarbecueManagementTool.models.response;

import com.practice.BarbecueManagementTool.models.EventUserJunction;

/**
 * Response model for AddParticipant Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
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
