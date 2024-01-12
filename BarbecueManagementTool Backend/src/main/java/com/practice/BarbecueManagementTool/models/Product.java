package com.practice.BarbecueManagementTool.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Model class for the Product
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	@Column(unique = true)
	private String name;
	private ProductType productType;
	private Boolean isBaseProduct;

	/**
	 * Constructor without attributes
	 */
	public Product() {
		super();
	}

	/**
	 * Constructor with attributes
	 * 
	 * @param productId
	 * @param name
	 * @param productType
	 * @param isBaseProduct
	 */
	public Product(Integer productId, String name, ProductType productType, Boolean isBaseProduct) {
		super();
		this.productId = productId;
		this.name = name;
		this.productType = productType;
		this.isBaseProduct = isBaseProduct;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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