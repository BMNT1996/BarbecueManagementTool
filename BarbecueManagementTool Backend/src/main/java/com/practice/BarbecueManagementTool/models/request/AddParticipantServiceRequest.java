package com.practice.BarbecueManagementTool.models.request;

import com.practice.BarbecueManagementTool.models.ApplicationUser;
import com.practice.BarbecueManagementTool.models.Event;

public class AddParticipantServiceRequest {

	private Event event;
	private ApplicationUser user;
	private Boolean accepted;

	public AddParticipantServiceRequest() {
		super();
	}

	public AddParticipantServiceRequest(Event event, ApplicationUser user, Boolean accepted) {
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
