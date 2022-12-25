package com.myblog.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtAuthicationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String reqestToken = request.getHeader("Authorization");

		String userName = null;
		String mainToken = null;

		if (reqestToken != null && reqestToken.startsWith("Bearer")) {

			mainToken = reqestToken.substring(7);
			try {
				userName = jwtUtil.getUserNameFromToken(mainToken);

			} catch (IllegalArgumentException il) {
				System.out.println("Mai illegle hunn...");
			} catch (ExpiredJwtException il) {
				System.out.println("Mai ExpiredJwtException hunn...");
			} catch (MalformedJwtException il) {
				System.out.println("Mai MalformedJwtException hunn...");
			}

		} else {
			System.out.println("SomeThing wrong in jwtClass");
		}

		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(userName);

			if (jwtUtil.validateToken(mainToken, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetails(request));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			} else {
				System.out.println("Kuch galat hai");
			}

		} else {
			System.out.println("Bhai userName khali hai");
		}
		
		filterChain.doFilter(request, response);

	}

}
