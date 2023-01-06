package com.myblog.Model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserAuthModel implements UserDetails{
	
	private User user;
	
	public UserAuthModel(User userWithDb) {
		this.user=userWithDb;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	Collection<GrantedAuthority> auth = new ArrayList<>();
	SimpleGrantedAuthority simple = new SimpleGrantedAuthority(user.getRole());
	auth.add(simple);
		return auth;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getUserPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
