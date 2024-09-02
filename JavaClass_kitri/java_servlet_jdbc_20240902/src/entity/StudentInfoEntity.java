package entity;

public class StudentInfoEntity {
	private int stu_id;
	private int stu_major;
	private String stu_name;
	private String stu_phone;
	
	public StudentInfoEntity() {}
	public StudentInfoEntity(int stu_id, int stu_major, String stu_name, String stu_phone) {
		super();
		this.stu_id = stu_id;
		this.stu_major = stu_major;
		this.stu_name = stu_name;
		this.stu_phone = stu_phone;
	}
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public int getStu_major() {
		return stu_major;
	}
	public void setStu_major(int stu_major) {
		this.stu_major = stu_major;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_phone() {
		return stu_phone;
	}
	public void setStu_phone(String stu_phone) {
		this.stu_phone = stu_phone;
	}
	
}
