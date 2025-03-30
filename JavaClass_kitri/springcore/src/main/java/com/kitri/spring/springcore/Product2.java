package com.kitri.spring.springcore;

import java.util.Set;

public class Product2 {
	private String nation;
	private Set<String> ity2;
	public void setProductIds(Set<String> productIds) {
		this.ity2 = productIds;
	}
	@Override
	public String toString() {
		return nation +"의 도시: "+ ity2.toString();
	}
	public void setCity(Set<String> city) {
		this.ity2 = city;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getNation() {
		return nation;
	}
	
}
