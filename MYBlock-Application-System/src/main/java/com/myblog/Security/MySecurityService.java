package com.myblog.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myblog.Exception.ResourseNotFoundException;
import com.myblog.Exception.ResponseNotFoundException;
import com.myblog.Model.User;
import com.myblog.Model.UserAuthModel;
import com.myblog.Repository.UserRepository;

@Service
public class MySecurityService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(username);
		if (user.isPresent()) {
			return new UserAuthModel(user.get());
		} else {
			throw new ResourseNotFoundException("User", "UserName", username);
		}

	}

}
