package com.practice.BarbecueManagementTool.models.response;

import com.practice.BarbecueManagementTool.models.EventProductJunction;

public class DeleteEventProductServiceResponse {

	private EventProductJunction eventProductJunction;

	public DeleteEventProductServiceResponse() {
		super();
	}

	public DeleteEventProductServiceResponse(EventProductJunction eventProductJunction) {
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
