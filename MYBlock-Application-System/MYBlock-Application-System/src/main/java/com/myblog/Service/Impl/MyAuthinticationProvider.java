package com.myblog.Service.Impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myblog.Model.User;
import com.myblog.Repository.UserRepository;


@Service
public class MyAuthinticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		System.out.println(username+ " "+password);
		System.out.println(authentication);
		
		User customer = userRepository.findByEmail(username).orElseThrow(()-> new BadCredentialsException("Something worng.."));
		
		if(passwordEncoder.matches(password, customer.getUserPassword())) {
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			
			return new UsernamePasswordAuthenticationToken(username,password, grantedAuthorities);
		}
		else throw new BadCredentialsException("Something is worng..");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
