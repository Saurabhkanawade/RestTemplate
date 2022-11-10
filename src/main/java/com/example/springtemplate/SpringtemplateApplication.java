package com.example.springtemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringtemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringtemplateApplication.class, args);
	}

 @Bean
public RestTemplate getRestTemplate() {
	return new RestTemplate();
}}
