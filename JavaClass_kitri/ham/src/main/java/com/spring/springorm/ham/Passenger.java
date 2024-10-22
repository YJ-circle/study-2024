package com.spring.springorm.ham;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passenger")
public class Passenger {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	public int getId() {
		return id;
	}

	public Passenger setId(int id) {
		this.id = id;
		return this;
	}

	public String getFirstName() {
		return firstName;
		
	}

	public Passenger setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public Passenger setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	

	
}
