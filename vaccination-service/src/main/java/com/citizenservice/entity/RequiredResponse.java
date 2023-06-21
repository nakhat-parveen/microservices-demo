package com.citizenservice.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredResponse {
	
	private Vaccination vaccinationcenter;
	private List<Citizen> citizens;

}
