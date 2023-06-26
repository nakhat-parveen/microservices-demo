package com.securitydemo.webclientconfigs;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import com.securitydemo.securityentities.Citizens;
import com.securitydemo.securityentities.Vaccination;



@HttpExchange("/citizens")
public interface CitizenServiceProvider {
	
	@PostExchange("/addCitizen")
	public ResponseEntity<Citizens> addcitizen(@RequestBody Citizens citizens);
	
	@GetExchange("/vaccinationsCenters")
	public List<Vaccination> getAvailableVaccinationCenters();

}
