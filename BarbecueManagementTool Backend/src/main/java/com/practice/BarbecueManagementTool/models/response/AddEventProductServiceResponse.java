package com.practice.BarbecueManagementTool.models.response;

import com.practice.BarbecueManagementTool.models.EventProductJunction;

public class AddEventProductServiceResponse {

	private EventProductJunction eventProductJunction;

	public AddEventProductServiceResponse() {
		super();
	}

	public AddEventProductServiceResponse(EventProductJunction eventProductJunction) {
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
