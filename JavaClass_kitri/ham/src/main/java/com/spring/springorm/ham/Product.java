package com.spring.springorm.ham;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="goods")
public class Product {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "category")
	private String category;
	
	@Column(name= "price")
	private int price;
	
	@Column(name="stock")
	private int stock;

	public int getId() {
		return id;
	}

	public Product setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Product setName(String name) {
		this.name = name;
		return this;
	}

	public String getCategory() {
		return category;
	}

	public Product setCategory(String category) {
		this.category = category;
		return this;
	}

	public int getPrice() {
		return price;
	}

	public Product setPrice(int price) {
		this.price = price;
		return this;
	}

	public int getStock() {
		return stock;
	}

	public Product setStock(int stock) {
		this.stock = stock;
		return this;
	}

	@Override
	public String toString() {
		return "\nProduct [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", stock="
				+ stock + "]";
	}
	
	
}
