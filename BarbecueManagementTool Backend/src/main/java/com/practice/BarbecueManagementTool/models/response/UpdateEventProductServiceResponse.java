package com.practice.BarbecueManagementTool.models.response;

import com.practice.BarbecueManagementTool.models.EventProductJunction;

public class UpdateEventProductServiceResponse {

	private EventProductJunction eventProductJunction;

	public UpdateEventProductServiceResponse() {
		super();
	}

	public UpdateEventProductServiceResponse(EventProductJunction eventProductJunction) {
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
