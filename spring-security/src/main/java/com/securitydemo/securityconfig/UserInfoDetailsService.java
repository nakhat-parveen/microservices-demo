package com.securitydemo.securityconfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.securitydemo.dao.UserDao;
import com.securitydemo.securityentities.UserInfo;

@Service
public class UserInfoDetailsService implements UserDetailsService {
	
	@Autowired
	UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> user= userDao.findByUsername(username);
		
		return user.map(UserInfoDetails::new).orElseThrow(()-> new UsernameNotFoundException("user not found"));
	}

}
