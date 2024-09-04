package entity;

public class MemberInfoEntity {
	private String id;
	private String name;
	private int coupon;
	private int mile;
	private String active;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	public int getMile() {
		return mile;
	}
	public void setMile(int mile) {
		this.mile = mile;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
}
