package entity;

public class StudentInfoEntity {
	// 필드 영역
	private String id;
	private String name;
	private String address;
	private String tel;
	private String mail;
	
	// 생성자 영역
	public StudentInfoEntity() {}
	public StudentInfoEntity(String id, String name, String address, String tel, String mail) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.mail = mail;
	}
	
	// Getters/Setters
	public String getId() { return id; }
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() { return name; }
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() { return address; }
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getTel() { return tel; }
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getMail() { return mail; }
	public void setMail(String mail) {
		this.mail = mail;
	}
}
