package com.practice.BarbecueManagementTool.models.request;

import com.practice.BarbecueManagementTool.models.EventProductJunction;

public class DeleteEventProductServiceRequest {

	private EventProductJunction eventProductJunction;

	public DeleteEventProductServiceRequest() {
		super();
	}

	public DeleteEventProductServiceRequest(EventProductJunction eventProductJunction) {
		super();
		this.eventProductJunction = eventProductJunction;
	}

	public EventProductJunction getEventProductJunction() {
		return eventProductJunction;
	}

	public void setEventProductJunction(EventProductJunction eventProductJunction) {
		this.eventProductJunction = eventProductJunction;
	}
}
