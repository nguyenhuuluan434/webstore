package com.lsa.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	/*@RequestMapping("/")*/
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to Web Store!");
		model.addAttribute("tagline", "The one and only amazing web store");
		return "index";
	}

	/*@RequestMapping("/welcome")*/
	@RequestMapping("/")
	public ModelAndView showMessage() {
		System.out.println("in controller");
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("greeting", "Welcome to Web Store!");
		mv.addObject("tagline", "The one and only amazing web store");
		return mv;
	}
}
