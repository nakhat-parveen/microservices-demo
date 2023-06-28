package com.citizenmicroservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citizenmicroservice.entity.Citizens;

@Repository
public interface CitizensDao extends JpaRepository<Citizens, Integer> {
	
	List<Citizens> findByVaccinationcenterid(Integer id);


}
