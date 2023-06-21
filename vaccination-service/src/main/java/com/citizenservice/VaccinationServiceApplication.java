package com.citizenservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class VaccinationServiceApplication {

	public static void main(String[] args) {
		System.out.println("boo starts..");
		SpringApplication.run(VaccinationServiceApplication.class, args);
		System.out.println("boo ends..");
	}

}
