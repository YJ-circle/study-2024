package entity;

public class Student {
	private String id;
	private String majorCode;
	private String name;
	public Student() {}
	public Student(String id, String majorCode, String name) {
		this.id = id;
		this.majorCode = majorCode;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMajorCode() {
		return majorCode;
	}
	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
