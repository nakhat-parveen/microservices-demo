package com.citizenmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citizenmicroservice.entity.Citizens;
import com.citizenmicroservice.entity.Vaccination;
import com.citizenmicroservice.service.CitizensService;


@RestController
@RequestMapping("/citizens")
public class CitizensController {
	
	@Autowired
	CitizensService citizensService;
	
	@PostMapping("/addCitizen")
	public ResponseEntity<Citizens> addcitizen(@RequestBody Citizens citizens){
		
		return new ResponseEntity<Citizens>(citizensService.addCitizen(citizens), HttpStatus.OK);
		
	}
	
	@GetMapping("/vaccinationsCenters")
	public List<Vaccination> getAvailableVaccinationCenters(){
		System.out.println();
		
		return citizensService.getVaccinationCenters();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Citizens> getCitizenById(@PathVariable Integer id) throws Exception{
		return new ResponseEntity<Citizens>(citizensService.getCitizenById(id), HttpStatus.OK);
	}
	
	@GetMapping("/getRegisteredUsers/{id}")
	public ResponseEntity<List<Citizens>> getallRegisteredCitizens(@PathVariable Integer id){
		return new ResponseEntity<List<Citizens>>(citizensService.getAllCitizens(id), HttpStatus.OK);
	}

}
