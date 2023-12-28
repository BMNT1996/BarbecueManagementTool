package com.practice.BarbecueManagementTool.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PersonQuantityRelationshipId {

	@ManyToOne
	@JoinColumn(name = "user_id")
	private ApplicationUser user;
	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public PersonQuantityRelationshipId() {
		super();
	}

	public PersonQuantityRelationshipId(ApplicationUser user, Event event, Product product) {
		super();
		this.user = user;
		this.event = event;
		this.product = product;
	}

	public ApplicationUser getUser() {
		return user;
	}

	public void setUser(ApplicationUser user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
