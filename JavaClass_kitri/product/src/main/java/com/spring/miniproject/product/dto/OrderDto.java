package com.spring.miniproject.product.dto;

public class OrderDto {
	int orderId;
	String userId;
	int goodsId;
	int qty;

	public int getOrderId() {
		return orderId;
	}

	public String getUserId() {
		return userId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public int getQty() {
		return qty;
	}

	public OrderDto setOrderId(int orderId) {
		this.orderId = orderId;
		return this;
	}

	public OrderDto setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public OrderDto setGoodsId(int goodsId) {
		this.goodsId = goodsId;
		return this;
	}

	public OrderDto setQty(int qty) {
		this.qty = qty;
		return this;
	}

	@Override
	public String toString() {
		return "\n\nOrderDto [orderId=" + orderId + "\n" 
				+ "userId=" + userId +  "\n"
				+ "goodsId=" + goodsId + "\n"
				+ "qty=" + qty + "]";
	}
	
}
