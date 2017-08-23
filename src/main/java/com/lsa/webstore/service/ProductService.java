package com.lsa.webstore.service;

import java.util.List;
import java.util.Map;

import com.lsa.webstore.domain.Product;

public interface ProductService {
	List<Product> getAllProducts();

	Product getProductById(String productId);

	List<Product> getProductByCategory(String category);

	List<Product> getProductByFilter(Map<String, List<String>> filterParams);
}
