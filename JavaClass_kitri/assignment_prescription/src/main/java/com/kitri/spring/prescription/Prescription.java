package com.kitri.spring.prescription;

/***
 * @apiNote 처방전
 *
 */
public class Prescription {
	/***
	 * <<필드명>> 
	 * 의사정보 
	 * 환자정보 
	 * 처방약 
	 * 일일 복용 횟수 
	 * 주의사항 
	 * 처방기간(약 복용 일수)
	 */
	private Doctor doctor;
	private Patient patient;
	private String medicinename;
	private Integer takemedicineperday;
	private String caution;
	private Integer prescriptionperiod;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getMedicinename() {
		return medicinename;
	}

	public void setMedicinename(String medicinename) {
		this.medicinename = medicinename;
	}

	public Integer getTakemedicineperday() {
		return takemedicineperday;
	}

	public void setTakemedicineperday(Integer takemedicineperday) {
		this.takemedicineperday = takemedicineperday;
	}

	public String getCaution() {
		return caution;
	}

	public void setCaution(String caution) {
		this.caution = caution;
	}

	public Integer getPrescriptionperiod() {
		return prescriptionperiod;
	}

	public void setPrescriptionperiod(Integer prescriptionperiod) {
		this.prescriptionperiod = prescriptionperiod;
	}
	
	@Override
	public String toString() {
		String prescriptionToString = String.format(
		    doctor +
		  "%n=====================================%n" +
		    patient + 
		  "%n=====================================%n" +
		  "<<처방 내역>>%n" +
	      "처방약: %-6s    일일복용횟수: %d회%n" +
  	      "주의사항: %s%n" +
	      "처방기간: %d일%n", 
	      medicinename, takemedicineperday, 
	      caution, 
	      prescriptionperiod);
		return prescriptionToString;
	}
}
