package com.model;

public  class Patient {

	private String patientId;
	private String patientName;
	private String phoneNumber; 
	private String age;
	private String gender;
	private String medicalHistory;
	private String prefferedSpecialist;
	private String medicineFee;
	private String patientType;
	
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMedicalHistory() {
		return medicalHistory;
	}
	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	public String getPrefferedSpecialist() {
		return prefferedSpecialist;
	}
	public void setPrefferedSpecialist(String prefferedSpecialist) {
		this.prefferedSpecialist = prefferedSpecialist;
	}
	public String getMedicineFee() {
		return medicineFee;
	}
	public void setMedicineFee(String medicineFee) {
		this.medicineFee = medicineFee;
	}
	public String getPatientType() {
		return patientType;
	}
	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}
	public Patient(String patientId, String patientName, String phoneNumber, String age, String gender,
			String medicalHistory, String prefferedSpecialist, String medicineFee, String patientType) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.gender = gender;
		this.medicalHistory = medicalHistory;
		this.prefferedSpecialist = prefferedSpecialist;
		this.medicineFee = medicineFee;
		this.patientType = patientType;
	}
	public Patient() {
		super();
	}
	
	
	

	
}