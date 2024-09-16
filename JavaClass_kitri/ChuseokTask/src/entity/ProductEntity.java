package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductEntity implements IEntity {
	private boolean init;
	String code;
	String name;
	int price;
	String factory;
	int categoryCode;
	String category;
	String imgPath;
	String detail;
	
	public ProductEntity() {}
	
	



	@Override
	public void setEntity(ResultSet sqlResult) throws SQLException {
		code = sqlResult.getString("code");
		name = sqlResult.getString("name");
		price = sqlResult.getInt("price");
		factory = sqlResult.getString("factory");
		categoryCode = sqlResult.getInt("categoryCode");
		category = sqlResult.getString("category");
		imgPath = sqlResult.getString("imgPath");
		detail = sqlResult.getString("detail");
		init = true;
	}
	
	public boolean isinit() {
		return init;
	}
	

	
	public String getCode() {
		return code;
	}



	public String getName() {
		return name;
	}



	public int getPrice() {
		return price;
	}



	public String getFactory() {
		return factory;
	}



	public int getCategoryCode() {
		return categoryCode;
	}



	public String getCategory() {
		return category;
	}



	public String getImgPath() {
		return imgPath;
	}

	




	public String getDetail() {
		return detail;
	}





	@Override
	public String toString() {
		return "ProductEntity [init=" + init + ", code=" + code + ", name=" + name + ", price=" + price + ", factory="
				+ factory + ", categoryCode=" + categoryCode + ", category=" + category + ", imgPath=" + imgPath
				+ ", detail=" + detail + "]";
	}






	
	
	
}
