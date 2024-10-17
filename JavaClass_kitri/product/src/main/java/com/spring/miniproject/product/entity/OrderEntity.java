package com.spring.miniproject.product.entity;

public class OrderEntity {
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

	public OrderEntity setOrderId(int orderId) {
		this.orderId = orderId;
		return this;
	}

	public OrderEntity setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public OrderEntity setGoodsId(int goodsId) {
		this.goodsId = goodsId;
		return this;
	}

	public OrderEntity setQty(int qty) {
		this.qty = qty;
		return this;
	}

	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId + ", userId=" + userId + ", goodsId=" + goodsId + ", qty=" + qty + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof OrderEntity) {
			return this.orderId == ((OrderEntity) obj).getOrderId();
		}
		return false;
	}
	

}
