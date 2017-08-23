package com.lsa.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lsa.webstore.service.ProductService;
import com.lsa.webstore.service.impl.ProductServiceImpl;

@Controller
public class ProductController {

	// way 1

	// @Resource(name = "productRepositoryImpl")
	// private ProductRepository productRepository;

	// way 2

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/products")
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

}
