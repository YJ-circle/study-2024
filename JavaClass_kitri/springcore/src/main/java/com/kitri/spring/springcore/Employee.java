package com.kitri.spring.springcore;

public class Employee {
	private String id;
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	

}
