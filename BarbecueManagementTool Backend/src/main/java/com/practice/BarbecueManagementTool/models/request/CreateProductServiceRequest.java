package com.practice.BarbecueManagementTool.models.request;

import com.practice.BarbecueManagementTool.models.ProductType;

/**
 * Request model for CreateProduct Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
public class CreateProductServiceRequest {

	private String name;
	private ProductType productType;
	private Boolean isBaseProduct;

	public CreateProductServiceRequest() {
		super();
	}

	public CreateProductServiceRequest(String name, ProductType productType, Boolean isBaseProduct) {
		super();
		this.name = name;
		this.productType = productType;
		this.isBaseProduct = isBaseProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Boolean getIsBaseProduct() {
		return isBaseProduct;
	}

	public void setIsBaseProduct(Boolean isBaseProduct) {
		this.isBaseProduct = isBaseProduct;
	}

}
