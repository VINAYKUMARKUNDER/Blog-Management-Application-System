package com.myblog.Service.Impl;
//package com.masai.service.Impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.masai.model.Customer;
//import com.masai.repo.CustomerRepository;
//
//public class MyAuthinticationProvider implements AuthenticationProvider {
//	
//	@Autowired
//	private CustomerRepository customerRepository;
//	
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	
//	
//
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		String username = authentication.getName();
//		String password = authentication.getCredentials().toString();
//		System.out.println(username+ " "+password);
//		
//		Customer customer = customerRepository.findByEmail(username).orElseThrow(()-> new BadCredentialsException("Something worng.."));
//		
//		if(passwordEncoder.matches(password, customer.getPassword())) {
//			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//			
//			return new UsernamePasswordAuthenticationToken(username,password, grantedAuthorities);
//		}
//		else throw new BadCredentialsException("Something is worng..");
//	}
//
//	@Override
//	public boolean supports(Class<?> authentication) {
//		
//		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
//	}
//
//}
