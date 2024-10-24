package com.spring.miniproject.product.dto;

public class OrderDto implements Comparable<OrderDto> {
	int orderId;
	String userId;
	int goodsId;
	String goodsName;
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
	
	public OrderDto setGoodsName(String goodsName) {
		this.goodsName = goodsName;
		return this;
	}
	public String getGoodsName() {
		return goodsName;
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
		return String.format(
				"주문id: %d%n"
			  + "주문자id: %s%n"
			  + "상품명: %s%n"
			  + "주문수량: %d",
			  orderId, userId, goodsName, qty
			  );
	}

	@Override
	public int compareTo(OrderDto o) {
		return orderId < o.orderId ? -1 : (orderId == o.orderId ? 0 : 1);
	}
	
	
}
