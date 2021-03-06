package com.lsa.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
class HomeController {
	
	@RequestMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to Web Store!");
		model.addAttribute("tagline", "The one and only amazing web store");
		return "welcome";
	}

	/*@RequestMapping("/welcome")*/
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showMessage() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("greeting", "Welcome to Web Store!");
		mv.addObject("tagline", "The one and only amazing web store");
		return mv;
	}
}
