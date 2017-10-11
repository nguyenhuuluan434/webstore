package com.lsa.webstore.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.lsa.webstore.domain.Product;

public interface ProductRepository {
	List<Product> getAllProduct();

	Product getProductById(String productId);

	List<Product> getProductByCategory(String category);

	List<Product> getProductByFilter(Map<String, List<String>> filterParams);

	List<Product> getProductsByManufacturer(String manufacturer);

	List<Product> getProductsBypriceFilter(Map<String, BigDecimal> filterParams);

	void addProduct(Product product);
}
