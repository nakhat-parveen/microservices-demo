package com.citizenmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citizenmicroservice.dao.CitizensDao;
import com.citizenmicroservice.entity.Citizens;
import com.citizenmicroservice.entity.Vaccination;


@Service
public class CitizensService {
	@Autowired
	CitizensDao dao;
	
	@Autowired
	 VaccinationProvider provider;
	
	public Citizens addCitizen(Citizens citizens) {
		return dao.save(citizens);
	}
	
	public List<Vaccination> getVaccinationCenters(){
		System.out.println("calling vaccination service through citizen service layer");
		return  provider.getAllVaccinationCenters().getBody();
	}

	public Citizens getCitizenById(Integer id) throws Exception {
		
		return dao.findById(id).orElseThrow(()-> new Exception("citizen not found"));
	}

	public List<Citizens> getAllCitizens(Integer id) {
		// TODO Auto-generated method stub
		return dao.findByVaccinationcenterid(id);
	}

	
	
	
//	public List<Citizens> getAllCitizens(Integer id){
//		return dao.findByVaccinationcenterid(id);
//	}

}
