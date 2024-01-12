package com.practice.BarbecueManagementTool.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Model class for the Event/User junction Id
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
@Embeddable
public class EventUserJunctionId {

	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private ApplicationUser user;

	/**
	 * Constructor without attributes
	 */
	public EventUserJunctionId() {
		super();
	}

	/**
	 * Constructor with attributes
	 * 
	 * @param event Event of the junction
	 * @param user User of the junction
	 */
	public EventUserJunctionId(Event event, ApplicationUser user) {
		super();
		this.event = event;
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public ApplicationUser getUser() {
		return user;
	}

	public void setUser(ApplicationUser user) {
		this.user = user;
	}

}
