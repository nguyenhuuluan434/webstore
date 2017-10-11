package com.lsa.webstore.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lsa.webstore.domain.Product;
import com.lsa.webstore.service.ProductService;

@Controller
@RequestMapping(value = "/products")
public class ProductController {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ProductController.class);
	// way 1

	// @Resource(name = "productRepositoryImpl")
	// private ProductRepository productRepository;

	// way 2

	@Autowired
	private ProductService productService;

	@RequestMapping("/tatca")
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping(value = "/all")
	public String allProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("products");
		modelAndView.addObject("products", productService.getAllProducts());
		return modelAndView;
	}

	@RequestMapping("/product")
	public ModelAndView getProductById(@RequestParam("id") String productId) {
		ModelAndView modelAndView = new ModelAndView("product");
		modelAndView.addObject("product", productService.getProductById(productId));
		return modelAndView;
	}

	@RequestMapping("/{category}")
	public ModelAndView getProductByCategory(@PathVariable("category") String category) {
		ModelAndView modelAndView = new ModelAndView("products");
		modelAndView.addObject("products", productService.getProductByCategory(category));
		return modelAndView;
	}

	@RequestMapping("/filter/{criteria}")
	public ModelAndView getProductByFilter(@MatrixVariable Map<String, List<String>> filterParams) {
		ModelAndView modelAndView = new ModelAndView("products");
		logger.debug(filterParams.toString());
		modelAndView.addObject("products", productService.getProductByFilter(filterParams));
		return modelAndView;
	}
	@RequestMapping(value="/add",method= RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute(product);
		return "addProduct";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("addProduct") Product product) {
		productService.addProduct(product);
		return "redirect:/product";
	}
}
