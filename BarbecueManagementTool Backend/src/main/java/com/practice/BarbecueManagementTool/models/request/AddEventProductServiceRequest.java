package com.practice.BarbecueManagementTool.models.request;

import com.practice.BarbecueManagementTool.models.DivisionType;
import com.practice.BarbecueManagementTool.models.Event;
import com.practice.BarbecueManagementTool.models.Product;

/**
 * Request model for AddEventProduct Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
public class AddEventProductServiceRequest {

	private Event event;
	private Product product;
	private Double quantity;
	private Double price;
	private DivisionType divisionType;

	public AddEventProductServiceRequest() {
		super();
	}

	public AddEventProductServiceRequest(Event event, Product product, Double quantity, Double price,
			DivisionType divisionType) {
		super();
		this.event = event;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.divisionType = divisionType;
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
