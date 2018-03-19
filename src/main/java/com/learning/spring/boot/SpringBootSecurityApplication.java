package com.learning.spring.boot;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableWebSecurity //customize security default behavior
@EnableOAuth2Sso
@RestController
public class SpringBootSecurityApplication extends WebSecurityConfigurerAdapter{

	@RequestMapping ("/user")
	public Principal user (Principal principle) {
		return principle;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
//		http.authorizeRequests().anyRequest().authenticated().and().formLogin();
		
		//for OAuth - making mandatory that all requests be authenticated
		http.authorizeRequests().anyRequest().authenticated();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}
}
