package com.practice.BarbecueManagementTool.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eventId;
	private String name;
	@Column(unique = true)
	private String eventCode;
	private LocalDateTime date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "event_user_ownership", joinColumns = { @JoinColumn(name = "event_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })
	private ApplicationUser owner;

	public Event() {
		super();
	}

	public Event(Integer eventId, String name, String eventCode, LocalDateTime date, ApplicationUser owner) {
		super();
		this.eventId = eventId;
		this.name = name;
		this.eventCode = eventCode;
		this.date = date;
		this.owner = owner;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public ApplicationUser getOwner() {
		return owner;
	}

	public void setOwner(ApplicationUser owner) {
		this.owner = owner;
	}

}
