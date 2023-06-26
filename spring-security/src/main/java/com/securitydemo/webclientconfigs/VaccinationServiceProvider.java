package com.securitydemo.webclientconfigs;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.securitydemo.securityentities.Vaccination;



@HttpExchange("/vaccination")
public interface VaccinationServiceProvider {
	
    @GetExchange("/centers")
	public ResponseEntity<List<Vaccination>> getAllVaccinationCenters();
    
    @GetExchange("/getVaccinationCenter/{id}")
    public ResponseEntity<Vaccination> getVaccinationCenterDetails(@PathVariable Integer id);
}
