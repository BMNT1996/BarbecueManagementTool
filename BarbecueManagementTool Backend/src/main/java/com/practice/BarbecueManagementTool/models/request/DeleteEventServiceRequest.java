package com.practice.BarbecueManagementTool.models.request;

import com.practice.BarbecueManagementTool.models.Event;

/**
 * Request model for DeleteEvent Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
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
