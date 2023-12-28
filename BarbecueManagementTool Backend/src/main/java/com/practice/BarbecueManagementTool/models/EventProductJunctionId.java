package com.practice.BarbecueManagementTool.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class EventProductJunctionId {

	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public EventProductJunctionId() {
		super();
	}

	public EventProductJunctionId(Integer eventProductJunctionId, Event event, Product product, Double quantity,
			DivisionType divisionType) {
		super();
		this.event = event;
		this.product = product;
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
