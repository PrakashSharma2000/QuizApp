package com.quiz.model;



import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users implements UserDetails {

	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	
	private String username;
	private String password;
	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }
	
	@Override
    public String getPassword() {
        return password;
    }


    @Override
    public String getUsername() {
        return username;
    }
    
    public Users(String username,String password) {
    	this.username=username;
    	this.password=password;
    }
}
