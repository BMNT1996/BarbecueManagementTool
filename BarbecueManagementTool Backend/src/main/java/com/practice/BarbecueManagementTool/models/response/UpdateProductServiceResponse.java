package com.practice.BarbecueManagementTool.models.response;

import com.practice.BarbecueManagementTool.models.Product;

public class UpdateProductServiceResponse {

	private Product product;

	public UpdateProductServiceResponse() {
		super();
	}

	public UpdateProductServiceResponse(Product product) {
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
