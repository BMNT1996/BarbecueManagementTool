package com.practice.BarbecueManagementTool.models.response;

import com.practice.BarbecueManagementTool.models.Product;

/**
 * Response model for CreateProduct Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
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
