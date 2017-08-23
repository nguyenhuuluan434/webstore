package com.lsa.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lsa.webstore.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@RequestMapping("/P1234/2")
	public String process() {
		orderService.processOrder("P1234", 2);
		return "redirect:/products";
	}
}
