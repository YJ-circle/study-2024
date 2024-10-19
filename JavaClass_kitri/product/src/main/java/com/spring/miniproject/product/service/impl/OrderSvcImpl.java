package com.spring.miniproject.product.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.miniproject.product.dao.IOrderDao;
import com.spring.miniproject.product.dto.OrderCart;
import com.spring.miniproject.product.dto.OrderDto;
import com.spring.miniproject.product.entity.OrderEntity;
import com.spring.miniproject.product.service.INotificationSvc;
import com.spring.miniproject.product.service.IOrderSvc;


@Component("orderSvc")
public class OrderSvcImpl implements IOrderSvc{
	
	@Autowired
	private IOrderDao orderDao;
	
	@Autowired
	private INotificationSvc notiSvc;

	@Override
	public List<OrderDto> getOrderAll(){
		return convertToDto(orderDao.getOrderAll());
	}
	
	@Override
	public List<OrderDto> getOrderById(String orderId) {
		return convertToDto(orderDao.getOrderByUserId(orderId));
	}
	


	@Override
	public boolean insertOrder(OrderCart orderCart) {
		int orderInsertRow = orderDao.insertOrder(orderCart);
		if(orderInsertRow == orderCart.getOrderList().size() * 2) {
			try {
				notiSvc.sendOrderMsg(orderCart);
				notiSvc.sendLowStock();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
	
	private List<OrderDto> convertToDto(List<OrderEntity> entityList) {
		List<OrderDto> dto = new ArrayList<OrderDto>();
		for(OrderEntity entity: entityList) {
			dto.add(new OrderDto()
					.setGoodsId(entity.getGoodsId())
					.setOrderId(entity.getOrderId())
					.setQty(entity.getQty())
					.setUserId(entity.getUserId())
					.setGoodsName(entity.getGoodsName())
					);
		}
		return dto;
	}
}
