package com.practice.BarbecueManagementTool.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "event_product_junction")
public class EventProductJunction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eventProductJunctionId;

	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	private Double quantity;
	private DivisionType divisionType;

	public EventProductJunction() {
		super();
	}

	public EventProductJunction(Integer eventProductJunctionId, Event event, Product product, Double quantity,
			DivisionType divisionType) {
		super();
		this.eventProductJunctionId = eventProductJunctionId;
		this.event = event;
		this.product = product;
		this.quantity = quantity;
		this.divisionType = divisionType;
	}

	public Integer getEventProductJunctionId() {
		return eventProductJunctionId;
	}

	public void setEventProductJunctionId(Integer eventProductJunctionId) {
		this.eventProductJunctionId = eventProductJunctionId;
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

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public DivisionType getDivisionType() {
		return divisionType;
	}

	public void setDivisionType(DivisionType divisionType) {
		this.divisionType = divisionType;
	}

}
