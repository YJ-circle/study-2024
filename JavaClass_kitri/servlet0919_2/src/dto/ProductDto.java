package dto;

import java.text.NumberFormat;

public class ProductDto {
	String name;
	String type;
	int price;
	int weight;
	String weightUnit;
	int minCount;
	int maxCount;

	public ProductDto(String name, String type, int price, int weight, String weightUnit, int minCount, int maxCount) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.weight = weight;
		this.weightUnit = weightUnit;
		this.minCount = minCount;
		this.maxCount = maxCount;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getPrice() {
		return price;
	}

	public int getWeight() {
		return weight;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public int getMinCount() {
		return minCount;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public String getPriceToString() {
		return NumberFormat.getInstance().format(price) +"원";
	}
	public String getCountToString() {
		return minCount + "과~" + maxCount + "과"; 
	}
}
