package com.kitri.spring.springcore;

import java.util.Map;

public class Product3 {
	private String nation;
	private Map<String, String> map;
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	@Override
	public String toString() {
		return map.toString();
	}
	
}
