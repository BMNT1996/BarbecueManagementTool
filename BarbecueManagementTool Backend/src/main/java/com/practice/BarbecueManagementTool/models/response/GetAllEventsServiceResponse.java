package com.practice.BarbecueManagementTool.models.response;

import java.util.List;

import com.practice.BarbecueManagementTool.models.Event;

public class GetAllEventsServiceResponse {

	List<Event> events;

	public GetAllEventsServiceResponse() {
		super();
	}

	public GetAllEventsServiceResponse(List<Event> events) {
		this.events = events;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
