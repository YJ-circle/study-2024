package com.spring.miniproject.product.service;

import java.util.List;

import com.spring.miniproject.product.dto.OrderCart;
import com.spring.miniproject.product.dto.OrderDto;

public interface IOrderSvc {
	List<OrderDto> getOrderById(String orderId);
	List<OrderDto> getOrderAll();
	boolean insertOrder(OrderCart orderCart);

	
}
