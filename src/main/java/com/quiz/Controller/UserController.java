package com.quiz.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.quiz.Repository.UserRepository;
import com.quiz.Service.CustomUserDetailsService;
import com.quiz.model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
	@PostMapping("addUser")
	public String getMethodName(@RequestBody Users users) {
		customUserDetailsService.addUser(users);
		return "User added succesfully";
	}
	
}
