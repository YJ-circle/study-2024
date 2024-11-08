package com.kitri.spring.javawebbean.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kitri.spring.javawebbean.dao.OrderDao;
import com.kitri.spring.javawebbean.dto.OrderDto;


public class OrderSvc {
	
	@Autowired
	private OrderDao orderDao;
	
	public List<OrderDto> getOrderList() {
		return orderDao.getOrderList();
	}
	
	public void init() {
		System.out.println("Order Svc Init");
	}
	
	public void destroy() {
		System.out.println("Order Svc destroy");	
	}
	

}
