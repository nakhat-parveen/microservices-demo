package com.citizenservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.citizenservice.entity.Citizen;
import com.citizenservice.entity.CitizenFeign;
import com.citizenservice.entity.RequiredResponse;
import com.citizenservice.entity.UserInfo;
import com.citizenservice.entity.Vaccination;
import com.citizenservice.repo.UserInfoDao;
import com.citizenservice.repo.VaccinationRepo;

@Service
public class VaccinationService {
	
	@Autowired
	private VaccinationRepo vaccinationrepo;
	
	@Autowired
	private UserInfoDao userdao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private CitizenFeign feign;
	
	public Vaccination addCenter( Vaccination vaccinationcenter) {
		
		return vaccinationrepo.save(vaccinationcenter);
	}
	
	public RequiredResponse getallDetails(Integer id) {
		RequiredResponse response= new RequiredResponse();
		
		Vaccination addedCenter= vaccinationrepo.findById(id).get();
		response.setVaccinationcenter(addedCenter);
		List<Citizen> allcitizens= feign.getallRegisteredCitizens(id).getBody();
		response.setCitizens(allcitizens);
		return response;
		
	}
	
	public Vaccination getVaccinationCenter(Integer id) {
		return vaccinationrepo.findById(id).get();
		
	}
	
	public List<Vaccination> getAllVaccinationCenters(){
		return vaccinationrepo.findAll();
	}
	
	public UserInfo addUsers(UserInfo user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userdao.save(user);
	}

}
