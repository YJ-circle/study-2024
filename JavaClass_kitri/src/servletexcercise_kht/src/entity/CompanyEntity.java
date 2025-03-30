package entity;

public class CompanyEntity {
//	A01:02-222-2222:회사1:홍길동1:서울시1
	// 필드 영역
	private String cd;
	private String tel;
	private String name;
	private String representative;
	private String address;
	
	// 생성자 영역
	public CompanyEntity() {}
	public CompanyEntity(String cd, String tel, String name, String representative, String address) {
		this.cd = cd;
		this.tel = tel;
		this.name = name;
		this.representative = representative;
		this.address = address;
	}

	// Getters/Setters
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRepresentative() {
		return representative;
	}
	public void setRepresentative(String representative) {
		this.representative = representative;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
