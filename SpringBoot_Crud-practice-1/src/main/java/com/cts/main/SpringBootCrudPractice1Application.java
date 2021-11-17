package com.cts.main;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class SpringBootCrudPractice1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudPractice1Application.class, args);
	}

	
	//Internationalization
	@Bean
	public SessionLocaleResolver localeResolver() {
	SessionLocaleResolver resolver=new SessionLocaleResolver();
	resolver.setDefaultLocale(Locale.US);
	return resolver;
		
	}
	
	//Internationalization
	@Bean
	public ResourceBundleMessageSource messageSource() {
		
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		
		return messageSource;
	}
	
	
	
	
	
	
	
	
}
