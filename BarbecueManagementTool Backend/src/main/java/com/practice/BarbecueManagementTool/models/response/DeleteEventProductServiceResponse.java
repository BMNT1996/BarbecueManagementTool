package com.practice.BarbecueManagementTool.models.response;

import com.practice.BarbecueManagementTool.models.EventProductJunction;

/**
 * Response model for DeleteEventProduct Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
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
