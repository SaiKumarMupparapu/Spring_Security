package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserControllet {
	
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private AuthenticationManager authManager;
	
	
	@Autowired
	private UserService service;
	
	@PostMapping(value="/register", consumes = "application/json",produces = "text/plain")
	public ResponseEntity<String> register(@RequestBody User user){
		
		System.out.println("inside sigup method");
		
		user.setPswd(encoder.encode(user.getPswd()));
		User registeredUser = service.registerUser(user);
		if(registeredUser.getId()!=null) {
			return new ResponseEntity<>("Registration successful",HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>("Try again",HttpStatus.BAD_REQUEST);
		
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user){
				UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPswd());
		try {
			Authentication authenticated = authManager.authenticate(token);
			 if(authenticated.isAuthenticated()) {
				 return	new ResponseEntity<>("Welcome to dashboard",HttpStatus.OK);

			 }
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
		return new ResponseEntity<>("Invalid credentials",HttpStatus.BAD_REQUEST);
	}
}
