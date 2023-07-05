package com.securitydemo.securitycontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.securitydemo.dao.UserDao;
import com.securitydemo.dto.AuthRequest;
import com.securitydemo.securityconfig.UserInfoDetails;
import com.securitydemo.securityentities.Citizens;
import com.securitydemo.securityentities.UserInfo;
import com.securitydemo.securityentities.Vaccination;
import com.securitydemo.service.AuthService;
import com.securitydemo.webclientconfigs.CitizenServiceProvider;
import com.securitydemo.webclientconfigs.VaccinationServiceProvider;

@RestController
@RequestMapping("/auth")
public class SecurityController {
	
	@Autowired
	UserDao userdao;
	
	 @Autowired
	 private AuthService service;

	 @Autowired
	 private AuthenticationManager authenticationManager;
	 
	 @Autowired
	 UserDetailsService userDetailsService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/api")
	public String secure() {
		return "security working";
	}
	
	@GetMapping("/admin")
	//@PreAuthorize("hasRole('ADMIN')")
	public String belongToAdmin() {
		return "accessible only to admin";
	}
	
	@GetMapping("/users")
	public String belongToUsers() {
		return "accessible only to users";
	}
	
	@GetMapping("/both")
	public String belongToBoth() {
		return "accessible only to both";
	}
	
	@PostMapping("/registerUsers")
	public UserInfo registerUsers(@RequestBody UserInfo user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userdao.save(user);
	}
	
	 @PostMapping("/token")
	    public String getToken(@RequestBody AuthRequest authRequest) {
	        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
	        if (authenticate.isAuthenticated()) {
	            return service.generateToken(authRequest.getUsername());
	        } else {
	            throw new RuntimeException("invalid access");
	        }
	    }
	 
	 @PostMapping("/validate/{token}")
	    public String validateToken(@PathVariable String token, @RequestBody UserInfo user) {
		 String username= user.getUsername();
		 UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	        service.validateToken(token, userDetails);
	        return "Token is valid";
	    }
	
//	@PostMapping("/addCitizens")
//	Citizens addCitizens(@RequestBody Citizens citizen) {
//		return citizenServiceProvider.addcitizen(citizen).getBody();
//	}
//	
//	@GetMapping("/getCenters")
//	List<Vaccination> getCentersFromCitizenService(){
//		return citizenServiceProvider.getAvailableVaccinationCenters();
//	}
	
//	@GetMapping("/getCenter/{id}")
//	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
//	public Vaccination getCenterById(@PathVariable Integer id) {
//		return vaccinationServiceProvider.getVaccinationCenterDetails(id).getBody();
//	}
	

}
