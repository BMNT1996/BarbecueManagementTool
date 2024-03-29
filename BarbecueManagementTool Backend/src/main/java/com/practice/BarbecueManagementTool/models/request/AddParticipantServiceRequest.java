package com.practice.BarbecueManagementTool.models.request;

/**
 * Request model for AddParticipant Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
public class AddParticipantServiceRequest {

	private Integer eventId;
	private Integer userId;
	private Boolean accepted;

	public AddParticipantServiceRequest() {
		super();
	}

	public AddParticipantServiceRequest(Integer eventId, Integer userId, Boolean accepted) {
		super();
		this.eventId = eventId;
		this.userId = userId;
		this.accepted = accepted;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

}
