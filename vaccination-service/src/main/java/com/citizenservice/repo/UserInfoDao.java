package com.citizenservice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citizenservice.entity.UserInfo;
@Repository
public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {
	
	Optional<UserInfo> findByName(String name);

}
