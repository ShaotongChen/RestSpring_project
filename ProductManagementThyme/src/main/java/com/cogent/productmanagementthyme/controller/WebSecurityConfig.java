package com.cogent.productmanagementthyme.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
	System.out.println("LOGIN ....");	
		auth.inMemoryAuthentication().withUser("system").password("{noop}system").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("bbb").password("{noop}bbb").roles("USER");
	}
	
	public void configure(HttpSecurity http) throws Exception{
		
		http.antMatcher("/**").authorizeRequests().anyRequest().hasRole("USER")
		.and().formLogin().loginPage("/loginD")
		.failureUrl("/loginD?error=1")
		.loginProcessingUrl("/login")
		.permitAll().and().
		logout().logoutSuccessUrl("/");

	}
}
