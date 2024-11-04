package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecureController {
	
	
	@GetMapping("/secure")
	public String getSecurePage() {
		
		return "home";
		
	}

}
