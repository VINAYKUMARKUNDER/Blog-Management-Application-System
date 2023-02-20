//package com.myblog.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.myblog.Service.UserService;
//import com.myblog.utilDto.LoginDto;
//
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
//
//@RestController
//@RequestMapping("/api/v1/auth/")
//public class AuthController {
//	
////	@Autowired
////	private JwtUtil jwtUtil;
//	
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	
//	@PostMapping("/login")
//	public ResponseEntity<JwtAuthResponse> userLogin(@RequestBody LoginDto logindto){
////		userService.addRoll(1, 1);
//		
//		authenticate(logindto.getEmail(),logindto.getPassword());
//		UserDetails loadUserByUsername = userDetailsService.loadUserByUsername(logindto.getEmail());
//		
////		String token = jwtUtil.generateToken(loadUserByUsername);
////		
////		JwtAuthResponse response = new JwtAuthResponse();
////		response.setToken(token);
//		return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
//	}
//
//	private void authenticate(String email, String password) {
//		
//		UsernamePasswordAuthenticationToken details = new UsernamePasswordAuthenticationToken(email, password);
//		try {
//			authenticationManager.authenticate(details);
//		} catch (DisabledException e) {
//			System.out.println("User is diseled..");
//		}
//		
//	}
//
//}
