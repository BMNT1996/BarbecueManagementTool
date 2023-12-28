package com.practice.BarbecueManagementTool.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "event_product_junction")
public class EventProductJunction {

	@EmbeddedId
	private EventProductJunctionId eventProductJunctionId;

	private Double quantity;
	private Double price;
	private DivisionType divisionType;

	public EventProductJunction() {
		super();
	}

	public EventProductJunction(EventProductJunctionId eventProductJunctionId, Double quantity, Double price,
			DivisionType divisionType) {
		super();
		this.eventProductJunctionId = eventProductJunctionId;
		this.quantity = quantity;
		this.price = price;
		this.divisionType = divisionType;
	}

	public EventProductJunctionId getEventProductJunctionId() {
		return eventProductJunctionId;
	}

	public void setEventProductJunctionId(EventProductJunctionId eventProductJunctionId) {
		this.eventProductJunctionId = eventProductJunctionId;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public DivisionType getDivisionType() {
		return divisionType;
	}

	public void setDivisionType(DivisionType divisionType) {
		this.divisionType = divisionType;
	}

}
