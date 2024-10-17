package com.spring.miniproject.product.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderCart {
	private String userId;
	private List<OrderDto> orderList = new ArrayList<OrderDto>();
	
	public void addCart(int goodsId, int qty) {
		orderList.add(new OrderDto().setGoodsId(goodsId)
		              				.setQty(qty));
	}
	public List<OrderDto> getOrderList() {
		return orderList;
	}
	
	public OrderCart setUserId(String userId) {
		this.userId = userId;
		return this;
	}
	public String getUserId() {
		return userId;
	}
}
