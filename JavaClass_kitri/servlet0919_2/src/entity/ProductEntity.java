package entity;

public class ProductEntity {
	String code;
	String name;
	String type;
	int price;
	int weight;
	String weightUnit;
	int minCount;
	int maxCount;
	
	public String getCode() {
		return code;
	}
	public ProductEntity(String code, String name, String type, int price, int weight, String weightUnit, int minCount,
			int maxCount) {
		super();
		this.code = code;
		this.name = name;
		this.type = type;
		this.price = price;
		this.weight = weight;
		this.weightUnit = weightUnit;
		this.minCount = minCount;
		this.maxCount = maxCount;
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
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	
	
}
