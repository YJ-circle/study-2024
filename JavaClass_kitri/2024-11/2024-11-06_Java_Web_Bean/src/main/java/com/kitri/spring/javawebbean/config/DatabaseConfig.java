package com.kitri.spring.javawebbean.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {
	
	@Autowired
	DriverManagerDataSource driverManagerDataSource;
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource= 
			new DriverManagerDataSource();
		
		driverManagerDataSource
		.setDriverClassName("oracle.jdbc.OracleDriver");
		driverManagerDataSource
		.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		driverManagerDataSource
		.setUsername("springjdbc");
		driverManagerDataSource
		.setPassword("1234");
		
		return driverManagerDataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		
		jdbcTemplate
		.setDataSource(driverManagerDataSource);
		
		return jdbcTemplate;
	}

}
