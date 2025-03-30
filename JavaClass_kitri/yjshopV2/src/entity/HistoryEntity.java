package entity;

public class HistoryEntity {
	int sn;
	String productcode;
	String name;
	int price;
	String userId;
	String buyDate;
	int qty;
	String imgpath;
	String category;
	public HistoryEntity(int sn, String productcode, String name, int price, String userId, String buyDate, int qty,
			String imgpath, String category) {
		super();
		this.sn = sn;
		this.productcode = productcode;
		this.name = name;
		this.price = price;
		this.userId = userId;
		this.buyDate = buyDate;
		this.qty = qty;
		this.imgpath = imgpath;
		this.category = category;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}
