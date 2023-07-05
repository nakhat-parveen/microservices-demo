package com.securitydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.securitydemo.securityconfig.UserInfoDetails;

@Service
public class AuthService {
	
	@Autowired
	JwtService jwtService;
	
	
	
	public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public boolean validateToken(String token, UserDetails userDetails ) {
        return jwtService.validateToken(token, userDetails);
    }

}
