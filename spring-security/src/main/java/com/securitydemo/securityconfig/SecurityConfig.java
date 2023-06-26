package com.securitydemo.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	UserDetailsService userDetailsService() {
		return new UserInfoDetailsService();
	}
	
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception{
		return http.csrf().disable()
				.authorizeHttpRequests()
				//.requestMatchers("/secure/api", "/secure/registerUsers").permitAll()
				//.requestMatchers("/secure/admin", "/secure/getCenter/**")
				.requestMatchers("/secure/api", "/secure/registerUsers", "/secure/addCitizens", "/secure/getCenter/**").permitAll()
				.anyRequest().authenticated()
				.and().build();
				
				//.and().authorizeHttpRequests().antMatchers("/vaccination/**").authenticated()
		        
				//.and().formLogin().and().build();
		 
	
	}
	
	 
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());
	    }
	    
	   
	
	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
    {
        return config.getAuthenticationManager();
    }
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		 DaoAuthenticationProvider daoAuth=new DaoAuthenticationProvider();
		 daoAuth.setUserDetailsService(userDetailsService());
		 daoAuth.setPasswordEncoder(getPasswordEncoder());
		 return daoAuth;
	}

}
