package com.citizenservice.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;




@Configuration
public class SecuityConfig{
	
	@Autowired
	UserDetailsService userDetailService;

	
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/getAllDetails/").hasRole("USER")
		.antMatchers("/getVaccinationCenter/").hasRole("USER")
		.antMatchers("/vaccination/").permitAll()
		.and().httpBasic();
		 
	return	http.build();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
 public DaoAuthenticationProvider authenticationProvider() {
	 DaoAuthenticationProvider daoAuth=new DaoAuthenticationProvider();
	 daoAuth.setUserDetailsService(userDetailService);
	 daoAuth.setPasswordEncoder(getPasswordEncoder());
	 return daoAuth;
 }
}
