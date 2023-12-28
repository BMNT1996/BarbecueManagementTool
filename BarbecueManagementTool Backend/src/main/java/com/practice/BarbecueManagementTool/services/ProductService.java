package com.practice.BarbecueManagementTool.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.BarbecueManagementTool.models.Product;
import com.practice.BarbecueManagementTool.models.request.CreateProductServiceRequest;
import com.practice.BarbecueManagementTool.models.request.DeleteProductServiceRequest;
import com.practice.BarbecueManagementTool.models.request.UpdateProductServiceRequest;
import com.practice.BarbecueManagementTool.models.response.CreateProductServiceResponse;
import com.practice.BarbecueManagementTool.models.response.DeleteProductServiceResponse;
import com.practice.BarbecueManagementTool.models.response.UpdateProductServiceResponse;
import com.practice.BarbecueManagementTool.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Set<Product> getAllProducts() {
		try {
			return productRepository.getAllProducts().orElseThrow(() -> new Exception("An error as ocorred"));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public CreateProductServiceResponse CreateProduct(CreateProductServiceRequest request) {
		try {
			Product product = productRepository
					.save(new Product(null, request.getName(), request.getProductType(), request.getIsBaseProduct()));
			return new CreateProductServiceResponse(product);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public UpdateProductServiceResponse UpdateProduct(UpdateProductServiceRequest request) {
		try {
			productRepository.updateProduct(request.getProduct());
			;
			return new UpdateProductServiceResponse(request.getProduct());
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public DeleteProductServiceResponse DeleteProduct(DeleteProductServiceRequest request) {
		try {
			productRepository.deleteProduct(request.getProduct());
			return new DeleteProductServiceResponse(request.getProduct());
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
