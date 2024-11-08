package com.kitri.spring.javawebbean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kitri.spring.javawebbean.dao.UserDao;
import com.kitri.spring.javawebbean.dao.OrderDao;



@Configuration
public class DaoConfig {

	@Bean
	public UserDao userDao() {
		return new UserDao();
	}
	@Bean
	public OrderDao OrderDao() {
		return new OrderDao();
	}
	
}
