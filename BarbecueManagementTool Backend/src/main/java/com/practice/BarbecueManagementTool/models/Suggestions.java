package com.practice.BarbecueManagementTool.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Model class for the Event (For future implementation)
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
@Entity
@Table(name = "sujestions")
public class Suggestions {

	@Id
	@OneToOne
	@JoinColumn(name = "event_id")
	private Event event;
	@Id
	@OneToOne
	@JoinColumn(name = "user_id")
	private ApplicationUser user;
	private String suggestion;

	/**
	 * Constructor without attributes
	 */
	public Suggestions() {
		super();
	}

	/**
	 * Constructor with attributes
	 * 
	 * @param event
	 * @param user
	 * @param suggestion
	 */
	public Suggestions(Event event, ApplicationUser user, String suggestion) {
		super();
		this.event = event;
		this.user = user;
		this.suggestion = suggestion;
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

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

}