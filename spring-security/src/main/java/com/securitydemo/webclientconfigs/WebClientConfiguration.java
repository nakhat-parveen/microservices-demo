package com.securitydemo.webclientconfigs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;



@Configuration
public class WebClientConfiguration {
	
	@Bean
	WebClient citizenWebClient() {
		return WebClient.builder().baseUrl("http://localhost:8069").build();
	} 
	
	@Bean
	WebClient vaccinationWebClient() {
		return WebClient.builder().baseUrl("http://localhost:8065").build();
	} 
	
	@Bean
	CitizenServiceProvider callCitizenService() {
		 HttpServiceProxyFactory httpServiceProxyFactory =
	                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(citizenWebClient()))
	                        .build();
		 return httpServiceProxyFactory.createClient(CitizenServiceProvider.class);
	}
	@Bean
	VaccinationServiceProvider callVaccinationService() {
		 HttpServiceProxyFactory httpServiceProxyFactory =
	                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(vaccinationWebClient()))
	                        .build();
		 return httpServiceProxyFactory.createClient(VaccinationServiceProvider.class);
	}
	

}
