package com.myblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class AppConfig {
	
	@Bean
	public SecurityFilterChain springSecurityconfig(HttpSecurity http) throws Exception {
		
		http
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.csrf().disable()
		.authorizeHttpRequests()
		.mvcMatchers("/public/**", "/api/post/").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.addFilterBefore(new JwtTokenGenraterFilter(), BasicAuthenticationFilter.class)
		.addFilterAfter(new JwtTokenGenraterFilter(), BasicAuthenticationFilter.class)
		
		.formLogin()
		.and()
		.httpBasic();
		
		return http.build();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncodr() {
		return new BCryptPasswordEncoder();
	}

}
