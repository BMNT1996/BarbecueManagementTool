package com.practice.BarbecueManagementTool.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.practice.BarbecueManagementTool.models.Product;
import com.practice.BarbecueManagementTool.models.request.CreateProductServiceRequest;
import com.practice.BarbecueManagementTool.models.request.DeleteProductServiceRequest;
import com.practice.BarbecueManagementTool.models.request.UpdateProductServiceRequest;
import com.practice.BarbecueManagementTool.services.ProductService;

/**
 * Class with the controller for the Products
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * Method to get all the products in the database
	 * 
	 * @return Response model as Json String with the list of all products
	 */
	@GetMapping("/")
	public Set<Product> GetAllProducts() {
		return productService.getAllProducts();
	}

	/**
	 * Method to create a new product in the database.
	 * 
	 * @param request Request model with the product
	 * @return Response model as Json String with the product created
	 */
	@PostMapping("/create")
	public String createProduct(@RequestBody CreateProductServiceRequest request) {
		try {
			return ControllerUtils.objectToJsonString(productService.createProduct(request));
		} catch (Exception e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	/**
	 * Method to update an existent product in the database.
	 * 
	 * @param request Request model with the product updated
	 * @return Response model as Json String with the product updated confirmation
	 */
	@PostMapping("/update")
	public String updateProduct(@RequestBody UpdateProductServiceRequest request) {
		try {
			return ControllerUtils.objectToJsonString(productService.updateProduct(request));
		} catch (Exception e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	/**
	 * Method to delete an existent product in the database
	 * 
	 * @param request Request model with the product to be deleted
	 * @return Response model as Json String with the product that was deleted
	 */
	@PostMapping("/delete")
	public String deleteProduct(@RequestBody DeleteProductServiceRequest request) {
		try {
			return ControllerUtils.objectToJsonString(productService.deleteProduct(request));
		} catch (Exception e) {
			e.printStackTrace();
			return "error 500";
		}
	}
}
