//package com.myblog.Service.Impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.myblog.Model.User;
//import com.myblog.Repository.UserRepository;
//
//
//
//
//
//@Service
//public class CustomerUserDetailService implements UserDetailsService{
//	
//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////		System.out.println(username);
//		User customer = userRepository.findByEmail(username).get();
////				orElseThrow(()->new ResponseNotFoundException("User",  "Email"+username, 0));
//		if(customer==null)throw new BadCredentialsException("Something is wrong");
//		
//		return new UserData(customer);
//	}
//
//}
