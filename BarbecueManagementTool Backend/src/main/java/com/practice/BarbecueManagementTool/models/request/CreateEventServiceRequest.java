package com.practice.BarbecueManagementTool.models.request;

import java.time.LocalDateTime;

public class CreateEventServiceRequest {

	private String name;
	private LocalDateTime date;
	private Integer ownerId;

	public CreateEventServiceRequest() {
		super();
	}

	public CreateEventServiceRequest(String name, LocalDateTime date, Integer ownerId) {
		super();
		this.name = name;
		this.date = date;
		this.ownerId = ownerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

}
