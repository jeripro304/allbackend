package com.springsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userCredService() {
		UserDetails admincred=User.withUsername("Admin").password(passwordEncoder().encode("Reset@123")).roles("ADMIN").build();
		UserDetails customercred=User.withUsername("Customer").password(passwordEncoder().encode("Reset@123")).roles("CUSTOMER").build();
		InMemoryUserDetailsManager mydet=new InMemoryUserDetailsManager(admincred,customercred);
		return mydet;
	}
	
	@Bean
	public SecurityFilterChain mySecurityConfig(HttpSecurity hs) throws Exception {
		hs.csrf().disable()
		.authorizeHttpRequests()
//		.requestMatchers("/admin")
//		.hasRole("ADMIN")
//		.requestMatchers("/customer")
//		.hasRole("CUSTOMER")
		.requestMatchers("/public")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
		return hs.build();
	}

}
