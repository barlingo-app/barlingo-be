package com.barlingo.backend.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("*/**").allowedOrigins("http://localhost:3000", "https://app-uat.barlingo.es",
				"https://app.barlingo.es", "https://rc1.barlingo.es").allowCredentials(true);

	}

}
