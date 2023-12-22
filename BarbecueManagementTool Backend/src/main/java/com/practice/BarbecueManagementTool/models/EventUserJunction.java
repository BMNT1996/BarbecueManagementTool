package com.practice.BarbecueManagementTool.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "event_user_junction")
public class EventUserJunction {

	@Id
	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;
	@Id
	@ManyToOne
	@JoinColumn(name = "user_id")
	private ApplicationUser user;
	private Boolean accepted;

	public EventUserJunction() {
		super();
	}

	public EventUserJunction(Event event, ApplicationUser user, Boolean accepted) {
		super();
		this.event = event;
		this.user = user;
		this.accepted = accepted;
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

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

}
