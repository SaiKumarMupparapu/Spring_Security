package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {
	
	@GetMapping("/about")
	public String about() {
		return "We are working since 2021";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "Contact us +91 123456789";
	}
	
	@GetMapping("/withdraw")
	public String withdraw() {
		return "Withdraw was success";
	}
	
	@GetMapping("/deposit")
	public String deposit() {
		return "deposit was success";
	}
	

	
}
