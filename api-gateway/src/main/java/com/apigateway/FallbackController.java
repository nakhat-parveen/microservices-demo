package com.apigateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FallbackController {
	
	@RequestMapping("/citizenfallback")
	public String citizenServiceFallback() {
		return "citizen service is down. Please try again later";
	}
	
	@RequestMapping("/vaccinationfallback")
	public String vaccinationServiceFallback() {
		return "vaccination service is down. Please try again later";
	}

}
