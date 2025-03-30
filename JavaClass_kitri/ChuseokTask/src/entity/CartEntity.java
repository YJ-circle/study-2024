package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Formatter;

public class CartEntity implements IEntity {
	private boolean init;
	private String goodscode;
	private String goodsName;
	private String userid;
	private String sessionid;
	private int qty;
	private int price;
	private String active;
	private String recentdate;
	private String category;
	private String imgPath;

	public CartEntity() {
	}
	public CartEntity(String item, String id) {
		
	}
	@Override
	public void setEntity(ResultSet sqlResult) throws SQLException {
		goodscode = sqlResult.getString("goodscode");
		goodsName = sqlResult.getString("goodsName");
		userid = sqlResult.getString("userid");
		sessionid = sqlResult.getString("sessionid");
		qty = sqlResult.getInt("qty");
		price = sqlResult.getInt("price");
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
	
	public int getPrice() {
		return price;
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
	

	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public void setGoodscode(String goodscode) {
		this.goodscode = goodscode;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public void oldToNew(CartEntity oldCart) {
		if(oldCart!=null) {
			this.qty = this.qty + oldCart.getQty();
		}
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시 mm분 ss초"); 
		this.recentdate = dateTime.format(format);
	}
	@Override
	public String toString() {
		return "CartEntity [init=" + init + ", goodscode=" + goodscode + ", userid=" + userid + ", qty=" + qty
				+ ", active=" + active + ", recentdate=" + recentdate + ", category=" + category + ", imgPath="
				+ imgPath + "]";
	}

}
