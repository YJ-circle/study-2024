package com.kitri.spring.javawebbean.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan("com.kitri.spring.javawebbean")
@Configuration
@Import({DaoConfig.class, ServiceConfig.class})
public class SpringConfig extends WebMvcConfigurerAdapter {
	@Bean
	public ViewResolver viewresolver() {
		System.out.println("View Resolver Setting");
		InternalResourceViewResolver viewresolver = 
				new InternalResourceViewResolver();
		viewresolver.setPrefix("/WEB-INF/views/");
		viewresolver.setSuffix(".jsp");
		
		return viewresolver;
	}
	
	@Override
	public void configureDefaultServletHandling(
		DefaultServletHandlerConfigurer configurer) {
		System.out.println("연결!");
		configurer.enable();
	}
}
