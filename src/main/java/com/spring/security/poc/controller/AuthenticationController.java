package com.spring.security.poc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
	
	@RequestMapping("/")
	public String home() {
		return "Helloworld";
	}

	@RequestMapping("/login")
	public String login() {
		return "Login success";
	}
}
