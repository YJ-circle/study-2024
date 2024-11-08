package com.kitri.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kitri.springboot.dao.Dao;

@SpringBootApplication
public class SpringbootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
		
	}

}
