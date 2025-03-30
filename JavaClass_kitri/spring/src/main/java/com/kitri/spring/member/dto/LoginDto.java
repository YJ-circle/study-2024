package com.kitri.spring.member.dto;

public class LoginDto {
	private String inputId;
	private String inputPassword;
	public String getId() {
		return inputId;
	}
	public LoginDto setId(String id) {
		this.inputId = id;
		return this;
	}
	public String getPassword() {
		return inputPassword;
	}
	public LoginDto setPassword(String password) {
		this.inputPassword = password;
		return this;
	}
	

}
