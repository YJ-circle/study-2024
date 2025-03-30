package com.kitri.spring.javawebbean.dto;

public class OrderDto {
	private String orderId;
	private String goodsId;
	private String userId;
	public OrderDto(String orderId, String goodsId, String userId) {
		super();
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.userId = userId;
	}
	public OrderDto() {}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "OrderDto [orderId=" + orderId + ", goodsId=" + goodsId + ", userId=" + userId + "]";
	}
	
	
}
