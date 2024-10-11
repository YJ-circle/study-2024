package com.kitri.spring.prescription;

public class Patient {
	/**
	 * <<필드명>>
	 * 환자명
	 * 주소
	 * 병명
	 * 치료기간
	 */
	private String name;
	private String address;
	private String diseasename;
	private Integer treatmentPeriod;

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

	public String getDiseasename() {
		return diseasename;
	}

	public void setDiseasename(String diseasename) {
		this.diseasename = diseasename;
	}

	public Integer getTreatmentPeriod() {
		return treatmentPeriod;
	}

	public void setTreatmentPeriod(Integer treatmentPeriod) {
		this.treatmentPeriod = treatmentPeriod;
	}
	
	@Override
	public String toString() {
		String patient = String.format(
				"<<환자 정보>>\n"
			  + "의사명: %-6s    주소: %s\n"
			  + " 병명 : %-8s  치료기간: %s일\n", 
			  name, address, 
			  diseasename, treatmentPeriod);
		return patient;
		}
}

	