package com.practice.BarbecueManagementTool.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "person_quantity_relationship")
public class PersonQuantityRelationship {
	@Id
	@ManyToOne
	@JoinColumn(name = "user_id")
	private ApplicationUser user;
	@Id
	@ManyToOne
	@JoinColumn(name = "event_product_id")
	private EventProductJunction eventProductJunction;

	private Double quantity;

	public PersonQuantityRelationship() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonQuantityRelationship(ApplicationUser user, EventProductJunction eventProductJunction,
			Double quantity) {
		super();
		this.user = user;
		this.eventProductJunction = eventProductJunction;
		this.quantity = quantity;
	}

	public ApplicationUser getUser() {
		return user;
	}

	public void setUser(ApplicationUser user) {
		this.user = user;
	}

	public EventProductJunction getEventProductJunction() {
		return eventProductJunction;
	}

	public void setEventProductJunction(EventProductJunction eventProductJunction) {
		this.eventProductJunction = eventProductJunction;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

}
