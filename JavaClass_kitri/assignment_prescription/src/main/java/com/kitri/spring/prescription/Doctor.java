package com.kitri.spring.prescription;

public class Doctor {
	/**
	 * <<필드명>>
	 * 의사명 
	 * 병원명 
	 * 진료과 
	 * 경력기간
	 */
	private String name;
	private String hospitalname;
	private String department;
	private Integer careerPeriod;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHospitalname() {
		return hospitalname;
	}

	public void setHospitalname(String universityname) {
		this.hospitalname = universityname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getCareerPeriod() {
		return careerPeriod;
	}

	public void setCareerPeriod(Integer careerPeriod) {
		this.careerPeriod = careerPeriod;
	}
	
	@Override
	public String toString() {
		String doctorToString = String.format(
				"<<의사 정보>>\n"
			  + "의사명: %-6s    병원명: %s\n"
			  + "진료과: %-6s    경력기간: %s년\n", 
			  name, hospitalname, department, careerPeriod);
		return doctorToString;
	}
}
