package org.board.javaproject8springmvcmybatis.entity;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public class UserInfoEntity {
	private String id;
	private String pwd;
	private String name;
	private String address;
	private String email;
	private String tel;

	public UserInfoEntity(String id, String pwd, String name, String address, String email, String tel) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
		this.email = email;
		this.tel = tel;
	}

	public UserInfoEntity() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
