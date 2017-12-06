package com.spring.security.poc.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.put("name", "Venkatesh Kumar V.");
		return "Helloworld";
	}

//	@RequestMapping("/login")
//	public String login() {
//		return "Login success";
//	}
}
