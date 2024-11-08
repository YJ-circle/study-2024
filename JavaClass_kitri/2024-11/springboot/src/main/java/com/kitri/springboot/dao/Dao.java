package com.kitri.springboot.dao;

import org.springframework.stereotype.Repository;

@Repository
public class Dao {
	
	public Dao() {
		System.out.println("Dao bean is created");
	}
	public void hello() {
		System.out.println("hello");
	}
}
