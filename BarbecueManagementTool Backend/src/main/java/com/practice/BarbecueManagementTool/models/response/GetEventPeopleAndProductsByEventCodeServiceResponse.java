package com.practice.BarbecueManagementTool.models.response;

import java.util.List;

import com.practice.BarbecueManagementTool.models.Event;
import com.practice.BarbecueManagementTool.models.EventProductJunction;
import com.practice.BarbecueManagementTool.models.EventUserJunction;

/**
 * Response model for GetEventPeopleAndProductsByEventCode Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
public class GetEventPeopleAndProductsByEventCodeServiceResponse {

	private Event event;
	private List<EventUserJunction> people;
	private List<EventProductJunction> products;

	public GetEventPeopleAndProductsByEventCodeServiceResponse() {
		super();
	}

	public GetEventPeopleAndProductsByEventCodeServiceResponse(Event event, List<EventUserJunction> people,
			List<EventProductJunction> products) {
		super();
		this.event = event;
		this.people = people;
		this.products = products;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public List<EventUserJunction> getPeople() {
		return people;
	}

	public void setPeople(List<EventUserJunction> people) {
		this.people = people;
	}

	public List<EventProductJunction> getProducts() {
		return products;
	}

	public void setProducts(List<EventProductJunction> products) {
		this.products = products;
	}

}
