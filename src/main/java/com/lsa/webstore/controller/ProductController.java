package com.lsa.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lsa.webstore.domain.repository.ProductRepository;

@Controller
public class ProductController {

	// way 1

	//@Resource(name = "productRepositoryImpl")
	//private ProductRepository productRepository;

	// way 2
	
	@Autowired
	private ProductRepository productRepository;
	 
	@RequestMapping("/products")
	public String list(Model model) {
		model.addAttribute("products", productRepository.getAllProduct());
		return "products";
	}
}
