package com.practice.BarbecueManagementTool.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practice.BarbecueManagementTool.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query(value = "SELECT * FROM products", nativeQuery = true)
	Optional<Set<Product>> getAllProducts();

	@Modifying
	@Query(value = "UPDATE products SET name=:#{#product.name}, product_type=:#{#product.productType}, is_base_product=:#{#product.isBaseProduct} where product_id = :#{#product.productId}", nativeQuery = true)
	@Transactional
	void updateProduct(@Param("product") Product product);

	@Modifying
	@Query(value = "DELETE FROM products p WHERE p.product_id = :#{#product.productId}", nativeQuery = true)
	@Transactional
	void deleteProduct(Product product);
}