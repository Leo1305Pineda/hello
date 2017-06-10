package com.pedrocamejo;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//  registry.addResourceHandler("/resources/**")
		//	.addResourceLocations("/", "classpath:/").setCachePeriod(1);
		registry.addResourceHandler("/**").addResourceLocations("/").setCacheControl(CacheControl.noCache());
		super.addResourceHandlers(registry);
	}
}
