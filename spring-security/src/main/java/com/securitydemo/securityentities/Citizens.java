package com.securitydemo.securityentities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Citizens {
	
	
	private Integer id;
	private String name;
	private String address;
	private int vaccinationcenterid;

}
