package com.citizenservice.entity;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="http://CITIZEN-SERVICE/citizen")
public interface CitizenFeign {
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Citizen>> getallRegisteredCitizens(@PathVariable Integer id);

}
