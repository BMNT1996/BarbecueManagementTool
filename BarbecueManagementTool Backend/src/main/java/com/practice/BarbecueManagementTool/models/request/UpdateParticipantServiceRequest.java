package com.practice.BarbecueManagementTool.models.request;

import com.practice.BarbecueManagementTool.models.EventUserJunction;

/**
 * Request model for UpdateParticipant Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
public class UpdateParticipantServiceRequest {

	private EventUserJunction eventUserJunction;

	public UpdateParticipantServiceRequest() {
		super();
	}

	public UpdateParticipantServiceRequest(EventUserJunction eventUserJunction) {
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
