package com.lsa.webstore.domain.repository;

import java.util.List;
import java.util.Map;

import com.lsa.webstore.domain.Product;

public interface ProductRepository {
	List<Product> getAllProduct();

	Product getProductById(String productId);

	List<Product> getProductByCategory(String category);

	List<Product> getProductByFilter(Map<String, List<String>> filterParams);
}
