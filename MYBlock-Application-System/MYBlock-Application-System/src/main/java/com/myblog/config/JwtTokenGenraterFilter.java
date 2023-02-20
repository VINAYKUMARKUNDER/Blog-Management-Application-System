package com.myblog.config;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


public class JwtTokenGenraterFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {


		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		System.out.println(authentication);
		
		if(authentication != null) {
			SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes());
			
			String jwtKey = Jwts.builder()
			.setIssuer("Vinay")
			.setSubject("JWT tokan")
			.claim("username", authentication.getName())
			.claim("Authorities", populateAuthrity(authentication.getAuthorities()))
		    .setIssuedAt(new Date())
		    .setExpiration(new Date(new Date().getTime()+3000000))
		    .signWith(key).compact();
			
			response.setHeader(SecurityConstants.JWT_HEADER, jwtKey);	
		}	
			filterChain.doFilter(request, response);
	}
	
	
	private String populateAuthrity(Collection<? extends GrantedAuthority> authorities) {
		Set<String> auth = new TreeSet<>();
		
		authorities.forEach(a-> auth.add(a.getAuthority()));
		
		return String.join(",", auth);
	}


	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
	
		return !request.getServletPath().equals("/signIn");
	}

}
