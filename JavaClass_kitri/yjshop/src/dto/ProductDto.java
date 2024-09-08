package dto;

import java.text.NumberFormat;

public class ProductDto implements Dto{
	int code;
	String name;
	int price;
	String category;
	String imgPath;
	
	public ProductDto(int code, String name, int price, String category, String imgPath) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.category = category;
		this.imgPath = imgPath;
	}

	public int getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public String getCategory() {
		return category;
	}

	public String getImgPath() {
		return imgPath;
	}
	
	public String priceToString() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        String formattedNumber = numberFormat.format(price);
		return formattedNumber;
	}
	
	
}
