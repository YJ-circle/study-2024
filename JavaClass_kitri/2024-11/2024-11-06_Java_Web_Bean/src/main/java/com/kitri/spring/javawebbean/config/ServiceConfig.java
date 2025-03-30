package com.kitri.spring.javawebbean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kitri.spring.javawebbean.service.OrderSvc;
import com.kitri.spring.javawebbean.service.UserSvc;


@Configuration
public class ServiceConfig {
	
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public UserSvc userSvc(){
		return new UserSvc();
	}
	
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public OrderSvc orderSvc() {
		return new OrderSvc();
	}
	
	public void init(String text) {
		System.out.println(text + "init");
	}
	public void destroy(String text) {
		System.out.println(text + "destroy");
	}

}
