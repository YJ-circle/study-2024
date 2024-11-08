package com.kitri.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.springboot.Hello;
import com.kitri.springboot.dao.Dao;

@Service
public class Services {
	
	public Services() {
		System.out.println("서비스 Bean 생성");
	}
	@Autowired
	private Dao dao;
	
	public void hello() {
		System.out.println("dao 메소드 호출 - dao.hello()");
		dao.hello();
		Hello h = new Hello(1);
	}
}
