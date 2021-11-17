package com.cts.main.configuration;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfiguration {

	
	private static final Contact DEFAULT_CONTACT = new Contact("abc", "", "abc@gmail.com");
	private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
		      "Employee app Documentation",
		      "Employee Api Documentation",
		      "1.0",
		      "urn:tos",
		      DEFAULT_CONTACT,
		      "Apache 2.0",
		      "http://www.apache.org/licenses/LICENSE-2.0",
		      new ArrayList<>());

	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO);
	}
	
}
