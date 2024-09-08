package entity;

public class ProductEntity{
	int code;
	String name;
	int price;
	String factory;
	int categoryCode;
	String category;
	String imgPath;
	public ProductEntity(int code, String name, int price, String factory, int categoryCode, String category, String imgPath) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.factory = factory;
		this.categoryCode = categoryCode;
		this.category = category;
		this.imgPath = imgPath;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public int getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
}
