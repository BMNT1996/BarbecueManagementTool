package com.practice.BarbecueManagementTool.models.request;

import com.practice.BarbecueManagementTool.models.Product;

/**
 * Request model for DeleteProduct Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
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
