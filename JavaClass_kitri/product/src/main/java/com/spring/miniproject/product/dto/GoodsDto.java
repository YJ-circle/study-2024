package com.spring.miniproject.product.dto;

public class GoodsDto {
	int id;
	String name;
	String category;
	int price;
	int stock;

	public int getId() {
		return id;
	}

	public GoodsDto setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public GoodsDto setName(String name) {
		this.name = name;
		return this;
	}

	public String getCategory() {
		return category;
	}

	public GoodsDto setCategory(String category) {
		this.category = category;
		return this;
	}

	public int getPrice() {
		return price;
	}

	public GoodsDto setPrice(int price) {
		this.price = price;
		return this;
	}
	
	public int getStock() {
		return stock;
	}
	
	public GoodsDto setStock(int stock) {
		this.stock = stock;
		return this;
	}

	@Override
	public String toString() {
		return "GoodsDto [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", stock="
				+ stock + "]";
	}


	

}
