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

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public Set<Product> helloUserController() {
		return productService.getAllProducts();
	}

	@PostMapping("/create")
	public String CreateProduct(@RequestBody CreateProductServiceRequest request) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
					.writeValueAsString(productService.CreateProduct(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	@PostMapping("/update")
	public String UpdateProduct(@RequestBody UpdateProductServiceRequest request) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
					.writeValueAsString(productService.UpdateProduct(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error 500";
		}
	}

	@PostMapping("/delete")
	public String DeleteProduct(@RequestBody DeleteProductServiceRequest request) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
					.writeValueAsString(productService.DeleteProduct(request));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "error 500";
		}
	}
}
