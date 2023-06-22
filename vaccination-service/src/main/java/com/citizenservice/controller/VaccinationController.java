package com.citizenservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citizenservice.entity.RequiredResponse;
import com.citizenservice.entity.UserInfo;
import com.citizenservice.entity.Vaccination;
import com.citizenservice.service.VaccinationService;

@RestController
@RequestMapping("/vaccination")
public class VaccinationController {
	
	@Autowired
	private VaccinationService vaccinationService;
	
	
	@PostMapping("/addCenter")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Vaccination> addVaccinationCenter(@RequestBody Vaccination vaccination){
		return new ResponseEntity<Vaccination>(vaccinationService.addCenter(vaccination), HttpStatus.OK);
	}
	@GetMapping("/getAllDetails/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<RequiredResponse> getDetails(@PathVariable Integer id){
		return new ResponseEntity<RequiredResponse>(vaccinationService.getallDetails(id), HttpStatus.OK);
	}
	
	@GetMapping("/getVaccinationCenter/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Vaccination> getVaccinationCenterDetails(@PathVariable Integer id){
		return new ResponseEntity<Vaccination>(vaccinationService.getVaccinationCenter(id), HttpStatus.OK);
	}
	
	@GetMapping("/centers")
	
	public ResponseEntity<List<Vaccination>> getAllVaccinationCenters(){
		return new ResponseEntity<List<Vaccination>>(vaccinationService.getAllVaccinationCenters(), HttpStatus.OK);
	}
	
	@PostMapping("/addUsers")
	public ResponseEntity<UserInfo> addUsers(@RequestBody UserInfo user){
		return new ResponseEntity<>(vaccinationService.addUsers(user), HttpStatus.OK);
	}

}
