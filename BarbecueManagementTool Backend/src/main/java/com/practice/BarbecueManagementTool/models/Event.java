package com.practice.BarbecueManagementTool.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Model class for the Event
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
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

	/**
	 * Constructor without attributes
	 */
	public Event() {
		super();
	}

	/**
	 * Constructor with attributes
	 * 
	 * @param eventId Event's Id
	 * @param name Event's name
	 * @param eventCode Event's code
	 * @param date Event's date
	 */
	public Event(Integer eventId, String name, String eventCode, LocalDateTime date) {
		super();
		this.eventId = eventId;
		this.name = name;
		this.eventCode = eventCode;
		this.date = date;
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

}
