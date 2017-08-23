package com.lsa.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lsa.webstore.service.CustomerService;

@Controller
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping
	public String getAllCustomer(Model model) {
		model.addAttribute("customers", customerService.getAllCustomer());
		return "customers";
	}
}
