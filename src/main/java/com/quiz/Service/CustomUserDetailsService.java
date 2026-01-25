package com.quiz.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import com.quiz.Repository.UserRepository;
import com.quiz.model.Users;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	
	public void addUser(Users users) {
		// TODO Auto-generated method stub
		users.setPassword(encoder.encode(users.getPassword()));
		userRepository.save(users);
	}

	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		return userRepository
				.findByUsername(username)
				.orElseThrow(()-> 
				new UsernameNotFoundException(username));
	}
	
}
