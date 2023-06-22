package com.citizenservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.citizenservice.entity.UserInfo;
import com.citizenservice.entity.UserInfoDetails;
import com.citizenservice.repo.UserInfoDao;

public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	UserInfoDao userdao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userinfo=userdao.findByName(username);
		return userinfo.map(UserInfoDetails::new).orElseThrow(()-> new UsernameNotFoundException("user not found"));
		
	}

}
