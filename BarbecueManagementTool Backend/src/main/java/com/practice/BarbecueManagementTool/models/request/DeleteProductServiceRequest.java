package com.practice.BarbecueManagementTool.models.request;

import com.practice.BarbecueManagementTool.models.Product;

public class DeleteProductServiceRequest {

	private Product product;

	public DeleteProductServiceRequest() {
		super();
	}

	public DeleteProductServiceRequest(Product product) {
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
