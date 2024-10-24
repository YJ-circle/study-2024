package com.spring.miniproject.product.dto;

public class GoodsDto implements Comparable<GoodsDto>{
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
		
		return String.format(
				"상품id: %d%n"
			  + "상품명: %s%n"
			  + "카테고리: %s%n"
			  + "가격: %d%n"
			  + "재고: %d",
			     id, name, category, price, stock
			  );
	}

	@Override
	public int compareTo(GoodsDto o) {
		return id < o.id ? -1 : (id == o.id ? 0 : 1);
	}


	

}
