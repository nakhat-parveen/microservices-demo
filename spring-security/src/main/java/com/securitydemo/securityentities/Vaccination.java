package com.securitydemo.securityentities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccination {
	
	private Integer id;
	private String centername;
	private String centeraddress;


}
