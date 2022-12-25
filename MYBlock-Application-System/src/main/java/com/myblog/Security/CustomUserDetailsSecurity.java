package com.myblog.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.myblog.Exception.ResponseNotFoundException;
import com.myblog.Model.User;
import com.myblog.Repository.UserRepository;

@Service
//@Component
public class CustomUserDetailsSecurity implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		User user = userRepository.findByEmail(username).orElseThrow(()-> new ResponseNotFoundException("user ", "Email :"+username, 0));
		System.out.println(user);
		return user;
	}
	
	
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		System.out.println(email);
//        User user = userRepository.findByUserEmail(email);
//        if ( user != null){
//        	System.out.println(user);
//            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//            user.getRoles().forEach(role -> { authorities.add(new SimpleGrantedAuthority(role.getName()));});
//            return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getPassword(), authorities);
//        }
//        else{ throw new EntityNotFoundException("Entity not found"); }
//    }

}
