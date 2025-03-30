package com.spring.miniproject.product.entity;

public class GoodsEntity {
	int id;
	String name;
	String category;
	int price;
	int stock;

	public int getId() {
		return id;
	}

	public GoodsEntity setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public GoodsEntity setName(String name) {
		this.name = name;
		return this;
	}

	public String getCategory() {
		return category;
	}

	public GoodsEntity setCategory(String category) {
		this.category = category;
		return this;
	}

	public int getPrice() {
		return price;
	}

	public GoodsEntity setPrice(int price) {
		this.price = price;
		return this;
	}
	
	public int getStock() {
		return stock;
	}
	
	public GoodsEntity setStock(int stock) {
		this.stock = stock;
		return this;
	}

	@Override
	public String toString() {
		return "GoodsEntity [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", stock="
				+ stock + "]";
	}
	
	
}
