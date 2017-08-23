package com.lsa.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsa.webstore.domain.Product;
import com.lsa.webstore.domain.repository.ProductRepository;
import com.lsa.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void processOrder(String productId, int count) {
		// TODO Auto-generated method stub
		Product product = productRepository.getProductById(productId);
		if (product.getUnitsInStock() < count) {
			throw new IllegalArgumentException("Out of Stock. Available Units in stock" + product.getUnitsInStock());
		}
		product.setUnitsInStock(product.getUnitsInStock() - count);

	}

}
