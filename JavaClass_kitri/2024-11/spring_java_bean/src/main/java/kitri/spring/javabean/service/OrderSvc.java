package kitri.spring.javabean.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kitri.spring.javabean.dao.OrderDao;
import kitri.spring.javabean.dao.UserDao;
import kitri.spring.javabean.dto.OrderDto;
import kitri.spring.javabean.dto.UserDto;

public class OrderSvc {
	
	@Autowired
	private OrderDao orderDao;
	
	public List<OrderDto> getOrdeList() {
		return orderDao.getOrderList();
	}
	
	public void init() {
		System.out.println("Order Svc Init");
	}
	
	public void destroy() {
		System.out.println("Order Svc destroy");	
	}
	

}
