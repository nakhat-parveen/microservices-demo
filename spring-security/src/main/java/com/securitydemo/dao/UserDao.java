package com.securitydemo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.securitydemo.securityentities.UserInfo;

@Repository
public interface UserDao extends JpaRepository<UserInfo, Integer> {
	
	public Optional<UserInfo> findByUsername(String username);

}
