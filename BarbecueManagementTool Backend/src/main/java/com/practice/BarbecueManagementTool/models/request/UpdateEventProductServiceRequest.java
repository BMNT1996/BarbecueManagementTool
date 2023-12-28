package com.practice.BarbecueManagementTool.models.request;

import com.practice.BarbecueManagementTool.models.EventProductJunction;

public class UpdateEventProductServiceRequest {

	private EventProductJunction eventProductJunction;

	public UpdateEventProductServiceRequest() {
		super();
	}

	public UpdateEventProductServiceRequest(EventProductJunction eventProductJunction) {
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
