package com.kitri.spring.javawebbean.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kitri.spring.javawebbean.dao.UserDao;
import com.kitri.spring.javawebbean.dto.UserDto;


public class UserSvc {
	
	@Autowired
	private UserDao userDao;
	
	public List<UserDto> getUser() {
		return userDao.getUserList();
	}
	
	public void init() {
		System.out.println("User Svc Init");
	}

	public void destroy() {
		System.out.println("User Svc destroy");
	}

}
