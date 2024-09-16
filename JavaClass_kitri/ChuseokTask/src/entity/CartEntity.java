package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartEntity implements IEntity {
	private boolean init;
	String goodscode;
	String userid;
	int qty;
	int cartPrice;
	String active;
	String recentdate;
	String category;
	String imgPath;

	public CartEntity() {
	}

	@Override
	public void setEntity(ResultSet sqlResult) throws SQLException {
		goodscode = sqlResult.getString("goodscode");
		userid = sqlResult.getString("userid");
		qty = sqlResult.getInt("qty");
		active = sqlResult.getString("active");
		recentdate = sqlResult.getString("recentdate");
		category = sqlResult.getString("category");
		imgPath = sqlResult.getString("imgPath");
		init = true;
	}

	public boolean isInit() {
		return init;
	}

	public String getGoodscode() {
		return goodscode;
	}

	public String getUserid() {
		return userid;
	}

	public int getQty() {
		return qty;
	}
	
	public int getCartPrice() {
		return cartPrice;
	}

	public String getActive() {
		return active;
	}

	public String getRecentdate() {
		return recentdate;
	}

	public String getCategory() {
		return category;
	}

	public String getImgPath() {
		return imgPath;
	}

	@Override
	public String toString() {
		return "CartEntity [init=" + init + ", goodscode=" + goodscode + ", userid=" + userid + ", qty=" + qty
				+ ", active=" + active + ", recentdate=" + recentdate + ", category=" + category + ", imgPath="
				+ imgPath + "]";
	}

}
