package dto;

public class Dto {
	private String id;
	private String name;
	private String majorCode;
	private String majorName;
	public Dto() {}
	public Dto(String id, String name, String majorCode, String majorName) {
		this.id = id;
		this.name = name;
		this.majorCode = majorCode;
		this.majorName = majorName;
	}
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
	public String getMajorCode() {
		return majorCode;
	}
	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	
	

}
