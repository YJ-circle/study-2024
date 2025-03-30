package dto;

public class HistoryDto{
	String buyDate;
	String imgpath;
	String category;
	String name;
	int qty;
	public HistoryDto(String buyDate, String imgpath, String category, String name, int qty) {
		super();
		this.buyDate = buyDate;
		this.imgpath = imgpath;
		this.category = category;
		this.name = name;
		this.qty = qty;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
}
