package com.quiz.Service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	public String secretKey;
	
	public JwtService() {
		// TODO Auto-generated constructor stub
		secretKey = generateSecretKey();
	}
	
	
	public String generateSecretKey(){
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
			SecretKey secretKey= keyGen.generateKey();
			System.out.println("Secret Key: "+secretKey.toString());
			return Base64.getEncoder().encodeToString(secretKey.getEncoded());
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			throw new RuntimeException("Error generating secret key", e);
		}
	}

	public String generateToken(String username) {
		// TODO Auto-generated method stub
		
		Map<String, Object> claims = new HashMap<>();
		
		
		
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(username)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*3))
				.signWith(getKey(), SignatureAlgorithm.HS256).compact();
		
	}
	
	private Key getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
