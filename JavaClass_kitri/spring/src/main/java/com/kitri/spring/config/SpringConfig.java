package com.kitri.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("com.kitri.spring")
@EnableWebMvc
public class SpringConfig extends WebMvcConfigurerAdapter {
	
}
