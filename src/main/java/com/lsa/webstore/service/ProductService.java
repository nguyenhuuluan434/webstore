package com.lsa.webstore.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.lsa.webstore.domain.Product;

public interface ProductService {
	List<Product> getAllProducts();

	Product getProductById(String productId);

	List<Product> getProductByCategory(String category);

	List<Product> getProductByFilter(Map<String, List<String>> filterParams);

	List<Product> getProductsByManufacturer(String manufacturer);

	List<Product> getProductsBypriceFilter(Map<String, BigDecimal> filterParams);
}
