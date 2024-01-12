package com.practice.BarbecueManagementTool.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Model class for the Event/Product junction Id
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
@Embeddable
public class EventProductJunctionId {

	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	/**
	 * Constructor without attributes
	 */
	public EventProductJunctionId() {
		super();
	}

	/**
	 * Constructor with attributes
	 * 
	 * @param event Event of the junction
	 * @param product Product of the junction
	 */
	public EventProductJunctionId(Event event, Product product) {
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
