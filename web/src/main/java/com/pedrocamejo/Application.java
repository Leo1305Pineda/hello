package com.pedrocamejo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

//exclude=HibernateJpaAutoConfiguration.class
@EnableAutoConfiguration()
@ComponentScan("com.pedrocamejo")
public class Application extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(Application.class,ApplicationModelsConfiguration.class);
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class,args);
	}

}
