package com.personal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyAppConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/documentation/v2/api-docs", "/v2/api-docs");
		registry.addRedirectViewController("/documentation/configuration/ui", "/configuration/ui");
		registry.addRedirectViewController("/documentation/configuration/security", "/configuration/security");
		registry.addRedirectViewController("/documentation/swagger-resources", "/swagger-resources");
		registry.addRedirectViewController("/documentation", "/documentation/swagger-ui.html");
		registry.addRedirectViewController("/api/docs", "/swagger-ui.html");
	}
}
