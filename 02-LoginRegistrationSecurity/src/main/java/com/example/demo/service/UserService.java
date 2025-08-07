package com.example.demo.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repo.UserRepo;
import com.example.demo.entity.User;


@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repo.findByEmail(email);
		
		return new 
				org.springframework.security.core.userdetails
	            .User( user.getEmail(),user.getPswd(),Collections.emptyList());
	}
	
	public User registerUser(User user) {
		return repo.save(user);
	}

	

}

