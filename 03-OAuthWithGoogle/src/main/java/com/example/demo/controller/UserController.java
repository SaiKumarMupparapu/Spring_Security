package com.example.demo.controller;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@GetMapping("/home")
	@ResponseBody
	public String home() {
		return "<h1> Welcome </h1>"
				+ "<a href='/oauth2/authorization/google'>login with Google</a>"
				+"<a href='/oauth2/authorization/github'>login with Git-Hub</a>";
	}

	@GetMapping("/profile")
	@ResponseBody
	public Map<String, Object> dashboard(@AuthenticationPrincipal OAuth2User authenticatedUser) {
		return authenticatedUser.getAttributes();
	}
	
	
}
