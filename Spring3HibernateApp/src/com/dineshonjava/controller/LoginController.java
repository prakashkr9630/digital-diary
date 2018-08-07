package com.dineshonjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {		
		return new ModelAndView("index");
	}
		
	
}
