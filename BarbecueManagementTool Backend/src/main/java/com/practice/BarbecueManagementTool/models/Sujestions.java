package com.practice.BarbecueManagementTool.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sujestions")
public class Sujestions {

	@Id
	@OneToOne
	@JoinColumn(name = "event_id")
	private Event event;
	@Id
	@OneToOne
	@JoinColumn(name = "user_id")
	private ApplicationUser user;
	private String sujestion;

	public Sujestions() {
		super();
	}

	public Sujestions(Event event, ApplicationUser user, String sujestion) {
		super();
		this.event = event;
		this.user = user;
		this.sujestion = sujestion;
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

	public String getSujestion() {
		return sujestion;
	}

	public void setSujestion(String sujestion) {
		this.sujestion = sujestion;
	}

}