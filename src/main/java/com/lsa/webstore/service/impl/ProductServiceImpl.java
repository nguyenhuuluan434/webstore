package com.lsa.webstore.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsa.webstore.domain.Product;
import com.lsa.webstore.domain.repository.ProductRepository;
import com.lsa.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.getAllProduct();
	}

	@Override
	public Product getProductById(String productId) {
		// TODO Auto-generated method stub
		return productRepository.getProductById(productId);
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		// TODO Auto-generated method stub
		return productRepository.getProductByCategory(category);
	}

	@Override
	public List<Product> getProductByFilter(Map<String, List<String>> filterParams) {
		// TODO Auto-generated method stub
		return productRepository.getProductByFilter(filterParams);
	}

	@Override
	public List<Product> getProductsByManufacturer(String manufacturer) {
		// TODO Auto-generated method stub
		return productRepository.getProductsByManufacturer(manufacturer);
	}

	@Override
	public List<Product> getProductsBypriceFilter(Map<String, BigDecimal> filterParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.addProduct(product);
		
	}

	
}
