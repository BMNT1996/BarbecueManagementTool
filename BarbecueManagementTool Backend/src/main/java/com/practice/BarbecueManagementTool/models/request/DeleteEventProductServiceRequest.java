package com.practice.BarbecueManagementTool.models.request;

import com.practice.BarbecueManagementTool.models.EventProductJunction;

/**
 * Request model for DeleteEventProduct Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
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
