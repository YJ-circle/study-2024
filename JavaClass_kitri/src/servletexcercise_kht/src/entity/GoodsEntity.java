package entity;

public class GoodsEntity {
//	88111111:아이스크림1:서울시1:02-222-2222
	// 필드 영역
	private String cd;
	private String name;
	private String address;
	private String tel;

	// 생성자 영역
	public GoodsEntity() {
	}

	public GoodsEntity(String cd, String name, String address, String tel) {
		this.cd = cd;
		this.name = name;
		this.address = address;
		this.tel = tel;
	}

	// Getters/Setters
	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
