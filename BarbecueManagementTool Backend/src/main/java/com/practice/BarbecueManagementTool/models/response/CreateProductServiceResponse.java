package com.practice.BarbecueManagementTool.models.response;

import com.practice.BarbecueManagementTool.models.Product;

public class CreateProductServiceResponse {

	Product product;

	public CreateProductServiceResponse() {
		super();
	}

	public CreateProductServiceResponse(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
