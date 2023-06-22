package com.citizenservice.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.citizenservice.service.UserInfoUserDetailsService;




@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecuityConfig{
	
//	@Autowired
//	UserDetailsService userDetailService;
//	
	@Bean
	UserDetailsService userDetailsService() {
		return new UserInfoUserDetailsService();
	}

	
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception{
		return http.csrf().disable()
				.authorizeHttpRequests().antMatchers("/vaccination/centers", "/vaccination/addUsers").permitAll()
				.and().authorizeHttpRequests().antMatchers("/vaccination/**").authenticated()
		        .and().formLogin().and().build();
		 
	
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public AuthenticationProvider authenticationProvider() {
		 DaoAuthenticationProvider daoAuth=new DaoAuthenticationProvider();
		 daoAuth.setUserDetailsService(userDetailsService());
		 daoAuth.setPasswordEncoder(getPasswordEncoder());
		 return daoAuth;
	}

}
