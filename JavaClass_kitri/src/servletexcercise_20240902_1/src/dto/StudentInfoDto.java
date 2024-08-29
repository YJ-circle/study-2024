package dto;

public class StudentInfoDto {
	// 필드 영역
	private String id;
	private String name;
	private String address;
	
	// 생성자 영역
	public StudentInfoDto() {}
	public StudentInfoDto(String id, String name, String address, String tel, String mail) {
		this.id = id;
		this.name = name;
		this.address = address;
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
}
