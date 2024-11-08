package com.kitri.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="member")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity{
	
	@Id
	@Column(name="ID")
	String id;
	
	@Column(name="PASSWORD")
	String password;
	
	@Column(name="NAME")
	String name;
	
	@Column(name="ADDRESS")
	String address;
	
	@Column(name="EMAIL")
	String email;
	
	@Column(name="TEL")
	String tel;

	@Column(name="active")
	String active;
	
	@Column(name="TESTCOL")
	int testcol;

}
