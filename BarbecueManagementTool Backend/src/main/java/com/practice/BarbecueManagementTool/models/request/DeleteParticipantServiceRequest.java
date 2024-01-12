package com.practice.BarbecueManagementTool.models.request;

import com.practice.BarbecueManagementTool.models.EventUserJunction;

/**
 * Request model for DeleteParticipant Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
public class DeleteParticipantServiceRequest {

	private EventUserJunction eventUserJunction;

	public DeleteParticipantServiceRequest() {
		super();
	}

	public DeleteParticipantServiceRequest(EventUserJunction eventUserJunction) {
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
