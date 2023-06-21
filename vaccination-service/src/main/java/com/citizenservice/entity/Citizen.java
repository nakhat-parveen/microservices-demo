package com.citizenservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Citizen {
	
	private Integer id;
	private String name;
	private int vaccinationcenterid;

}
