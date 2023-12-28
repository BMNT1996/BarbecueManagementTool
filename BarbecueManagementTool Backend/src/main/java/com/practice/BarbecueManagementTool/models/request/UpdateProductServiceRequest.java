package com.practice.BarbecueManagementTool.models.request;

import com.practice.BarbecueManagementTool.models.Product;

public class UpdateProductServiceRequest {

	private Product product;

	public UpdateProductServiceRequest() {
		super();
	}

	public UpdateProductServiceRequest(Product product) {
		super();
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
