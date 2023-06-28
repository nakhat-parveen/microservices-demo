package com.citizenservice.entity;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name="http://CITIZEN-MICROSERVICE/citizens")
public interface CitizenFeign {
	
	@GetMapping("/getRegisteredUsers/{id}")
	public ResponseEntity<List<Citizens>> getallRegisteredCitizens(@PathVariable Integer id);
	
	@GetMapping("/{id}")
	public ResponseEntity<Citizens> getCitizenById(@PathVariable Integer id);

}
