package com.practice.BarbecueManagementTool.models.request;

import com.practice.BarbecueManagementTool.models.EventProductJunction;

/**
 * Request model for UpdateEventProduct Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
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
