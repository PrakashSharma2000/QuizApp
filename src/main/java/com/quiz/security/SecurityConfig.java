package com.quiz.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) {
		
//		http.csrf(customizer -> customizer.disable()); // we are disabling spring security
//		http.authorizeHttpRequests(auth -> auth
//				.requestMatchers("/addUser").permitAll()
//				.anyRequest().authenticated()); // we are enabling all port/ link request without id pass
//		http.formLogin(Customizer.withDefaults());//Enable form login
//		http.httpBasic(Customizer.withDefaults());//display form in pop up
//		http.logout(Customizer.withDefaults());
//		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // made stateless to overcome csrf issue
//		
    	http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(req -> req
            .requestMatchers("/login","/register").permitAll() // public
            .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults())
        .sessionManagement(session ->
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
    	
		return http.build();
	}
    
//    @Bean
//    UserDetailsService userDetailsService() {
//    	
//    	
//    	UserDetails user = User
//    			.builder()
//    			.username("your_default_password")
//    			.password(passwordEncoder().encode("Password"))
//    			.roles("USER")
//    			.build();
//    	
//    	return new InMemoryUserDetailsManager(user);
//    }
    
    @Bean
    PasswordEncoder passwordEncoder()
    {
    	return new BCryptPasswordEncoder();
    }
    
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config){
		
    	return config.getAuthenticationManager();	
    }
}
