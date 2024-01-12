package com.practice.BarbecueManagementTool.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Model class for the Event/User junction
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
@Entity
@Table(name = "event_user_junction")
public class EventUserJunction {

	@EmbeddedId
	private EventUserJunctionId eventUserJunctionId;

	private Boolean accepted;

	private Boolean isOwner;

	/**
	 * Constructor without attributes
	 */
	public EventUserJunction() {
		super();
	}

	/**
	 * Constructor with attributes
	 * 
	 * @param eventUserJunctionId Id
	 * @param accepted Information if the user is accepted in the event
	 * @param isOwner Information if the user is the owner of the event
	 */
	public EventUserJunction(EventUserJunctionId eventUserJunctionId, Boolean accepted, Boolean isOwner) {
		super();
		this.eventUserJunctionId = eventUserJunctionId;
		this.accepted = accepted;
		this.isOwner = isOwner;
	}

	public EventUserJunctionId getEventUserJunctionId() {
		return eventUserJunctionId;
	}

	public void setEventUserJunctionId(EventUserJunctionId eventUserJunctionId) {
		this.eventUserJunctionId = eventUserJunctionId;
	}

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	public Boolean getIsOwner() {
		return isOwner;
	}

	public void setIsOwner(Boolean isOwner) {
		this.isOwner = isOwner;
	}
}
