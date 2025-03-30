package com.kitri.spring.springcore;

import java.util.List;

public class Product {
	private List<Integer> productIds;
	
	public void setProductIds(List<Integer> productIds) {
		this.productIds = productIds;
	}
	public List<Integer> getProductIds() {
		return productIds;
	}
	@Override
	public String toString() {
		return productIds.toString();
	}
	
	
}
