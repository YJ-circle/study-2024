package dto;

public class StudentDto {
	private int stu_id;
	private String stu_name;
	public StudentDto() {}
	public StudentDto(int stu_id, String stu_name) {
		this.stu_id = stu_id;
		this.stu_name = stu_name;
	}
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	

}
