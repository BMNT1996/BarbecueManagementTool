package com.practice.BarbecueManagementTool.models.response;

import com.practice.BarbecueManagementTool.models.Product;

/**
 * Response model for UpdateProduct Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
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
