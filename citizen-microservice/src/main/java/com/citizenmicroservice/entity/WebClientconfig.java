package com.citizenmicroservice.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.citizenmicroservice.service.VaccinationProvider;


@Configuration
public class WebClientconfig {
	
	@Bean
	WebClient webClient() {
		return WebClient.builder().baseUrl("http://localhost:8065").build();
	}
	
	@Bean
	VaccinationProvider toDoService() {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient()))
                        .build();
        return httpServiceProxyFactory.createClient(VaccinationProvider.class);
    }

}
