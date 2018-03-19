package com.learning.spring.boot;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.stereotype.Component;

@Component
//The event AbstractAuthenticationFailureEvent will be triggered when the user fails to authenticate with our application
public class CustomSecurityEventListener implements ApplicationListener<AbstractAuthenticationFailureEvent> {

	@Override
	public void onApplicationEvent(AbstractAuthenticationFailureEvent event) {
		System.out.println("Printing the security failure : " + event.getException().getMessage());
	}
}
