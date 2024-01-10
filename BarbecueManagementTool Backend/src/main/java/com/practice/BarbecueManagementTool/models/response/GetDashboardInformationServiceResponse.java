package com.practice.BarbecueManagementTool.models.response;

import java.util.ArrayList;

import com.practice.BarbecueManagementTool.models.EventInformation;

public class GetDashboardInformationServiceResponse {

	private int numberOfEvents;
	private double productsRequested;
	private double totalExpenses;
	private ArrayList<EventInformation> events;
	private ArrayList<EventInformation> eventsPending;

	public GetDashboardInformationServiceResponse() {
		super();
		events = new ArrayList<EventInformation>();
		eventsPending = new ArrayList<EventInformation>();
	}

	public GetDashboardInformationServiceResponse(int numberOfEvents, double productsRequested, double totalExpenses,
			ArrayList<EventInformation> events, ArrayList<EventInformation> eventsPending) {
		super();
		this.numberOfEvents = numberOfEvents;
		this.productsRequested = productsRequested;
		this.totalExpenses = totalExpenses;
		this.events = events;
		this.eventsPending = eventsPending;
	}

	public int getNumberOfEvents() {
		return numberOfEvents;
	}

	public void setNumberOfEvents(int numberOfEvents) {
		this.numberOfEvents = numberOfEvents;
	}

	public double getProductsRequested() {
		return productsRequested;
	}

	public void setProductsRequested(double productsRequested) {
		this.productsRequested = productsRequested;
	}

	public double getTotalExpenses() {
		return totalExpenses;
	}

	public void setTotalExpenses(double totalExpenses) {
		this.totalExpenses = totalExpenses;
	}

	public ArrayList<EventInformation> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<EventInformation> events) {
		this.events = events;
	}
	
	public void addEvent(EventInformation event) {
		if(events == null) {
			events = new ArrayList<EventInformation>();
		}
		events.add(event);
	}
	
	public ArrayList<EventInformation> getEventsPending() {
		return eventsPending;
	}

	public void setEventsPending(ArrayList<EventInformation> eventsPending) {
		this.eventsPending = eventsPending;
	}
	
	public void addEventPending(EventInformation eventPending) {
		if(eventsPending == null) {
			eventsPending = new ArrayList<EventInformation>();
		}
		eventsPending.add(eventPending);
	}


}
