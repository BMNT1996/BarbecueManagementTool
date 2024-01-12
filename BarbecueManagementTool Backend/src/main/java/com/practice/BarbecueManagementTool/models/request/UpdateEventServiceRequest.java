package com.practice.BarbecueManagementTool.models.request;

import com.practice.BarbecueManagementTool.models.Event;

/**
 * Request model for UpdateEvent Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
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
