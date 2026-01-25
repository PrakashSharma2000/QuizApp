package com.quiz.Controller;

import org.springframework.web.bind.annotation.RestController;
import com.quiz.Service.CustomUserDetailsService;
import com.quiz.Service.JwtService;
import com.quiz.model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

 
@RestController
public class UserController {
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtService jwtService;
	
	@PostMapping("register")
	public String register(@RequestBody Users users) {
		customUserDetailsService.addUser(users);
		return "User added succesfully";
	}
	
	@PostMapping("login")
	public String loginUser (@RequestBody Users users) {
		
		Authentication authentication= authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken( users.getUsername(),users.getPassword()));
		
		return authentication.isAuthenticated()?jwtService.generateToken(users.getUsername()):"failed";
		
	}
	
}
