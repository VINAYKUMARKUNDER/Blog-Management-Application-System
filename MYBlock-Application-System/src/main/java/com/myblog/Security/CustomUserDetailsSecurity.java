//package com.myblog.Security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.myblog.Exception.ResponseNotFoundException;
//import com.myblog.Model.User;
//import com.myblog.Repository.UserRepository;
//
//@Service
////@Component
//public class CustomUserDetailsSecurity implements UserDetailsService{
//	
//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepository.findByEmail(username).orElseThrow(()-> new ResponseNotFoundException("user ", "Email :"+username, 0));
//		System.out.println(user);
//		return user;
//	}
//	
//
//}
