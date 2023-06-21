package com.citizenmicroservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.citizenmicroservice.entity.Vaccination;



@HttpExchange("/vaccination")
public interface VaccinationProvider {
	
	@GetExchange("/")
	public ResponseEntity<List<Vaccination>> getAllVaccinationCenters();

}
