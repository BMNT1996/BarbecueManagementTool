package com.practice.BarbecueManagementTool.models.response;

import com.practice.BarbecueManagementTool.models.Product;

public class DeleteProductServiceResponse {

	private Product product;

	public DeleteProductServiceResponse() {
		super();
	}

	public DeleteProductServiceResponse(Product product) {
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