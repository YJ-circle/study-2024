package com.kitri.spring.aspect01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class Member {
	public Member(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	private String id;
	private String password;
	private String name;
	private String address;
	private String email;
	
}
