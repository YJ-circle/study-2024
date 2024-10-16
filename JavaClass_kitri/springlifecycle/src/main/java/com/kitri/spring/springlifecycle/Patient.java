package com.kitri.spring.springlifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
			  + "환자명: %-6s   주소: %-5s\n"
			  + " 병명 : %-8s  치료기간: %-5s\n", 
			  name, address, 
			  diseasename, treatmentPeriod + "일");
		return patient;
		}
	
	
	//Bean이 생성된 직후
	
	@PostConstruct
	public void afterCreateBean() {
		System.out.println("빈 생성");
	}
	
	@PreDestroy
	public void afterDisposalBean() {
		System.out.println("빈 삭제");
	}
}

	