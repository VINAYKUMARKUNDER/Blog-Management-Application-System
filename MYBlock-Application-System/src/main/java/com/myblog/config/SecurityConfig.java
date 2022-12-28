package com.myblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf()
		.disable()
		.authorizeHttpRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Masai").password(this.passwordEncoder().encode("masai30"))
				.roles("ADMIN");
		auth.inMemoryAuthentication().withUser("Vinay").password(this.passwordEncoder().encode("vinay")).roles("USER");
		auth.inMemoryAuthentication().withUser("Akhilesh").password(this.passwordEncoder().encode("akhilesh"))
				.roles("USER");
		auth.inMemoryAuthentication().withUser("Rahul").password(this.passwordEncoder().encode("rahul")).roles("USER");
		auth.inMemoryAuthentication().withUser("Rohit").password(this.passwordEncoder().encode("rohit")).roles("USER");
		auth.inMemoryAuthentication().withUser("Mukesh").password(this.passwordEncoder().encode("mukesh"))
				.roles("USER");
		auth.inMemoryAuthentication().withUser("Kamal").password(this.passwordEncoder().encode("kamal")).roles("USER");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

}
