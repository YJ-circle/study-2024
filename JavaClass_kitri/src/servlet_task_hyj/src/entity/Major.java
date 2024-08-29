package entity;

public class Major {
	private String majorCode;
	private String majorName;
	public Major() {}
	public Major(String majorCode, String majorName) {
		super();
		this.majorCode = majorCode;
		this.majorName = majorName;
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
