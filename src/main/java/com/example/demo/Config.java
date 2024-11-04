package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="com.example.demo")
public class Config {
	
	@Bean
	 InternalResourceViewResolver viewSolver() {
		
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("src/main/resources/templates");
		resolver.setSuffix(".html");
		return resolver;
	}
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(Customizer->{
			Customizer.requestMatchers("/secure").authenticated().
			anyRequest().permitAll();
		});
		http.formLogin(Customizer.withDefaults());
		http.oauth2Login(Customizer.withDefaults());
		return http.build();
	}
	
	
	@Bean
	ClientRegistrationRepository clientRepositry() {
		
		return new InMemoryClientRegistrationRepository(clientRegistration());
	}
	
	@Bean
	ClientRegistration clientRegistration() {
		return CommonOAuth2Provider.GITHUB.getBuilder("github").clientId("Ov23liJtS7QG06ghedTg").clientSecret("ee44ffe3c966e70acbfa10d30ba064bce22b10").build();
		
	}

}
