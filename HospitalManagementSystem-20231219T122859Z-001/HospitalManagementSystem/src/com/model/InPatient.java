package com.model;

public class InPatient extends Patient {
	
	private String admissionFees;
	private String treatment;
	private String roomType;
	private String wantFood;
	
	
	
	
	
	
	public InPatient(String patientId, String patientName, String phoneNumber, String age, String gender,
			String medicalHistory, String prefferedSpecialist, String medicineFee, String patientType,
			String admissionFees, String treatment, String roomType, String wantFood) {
		super(patientId, patientName, phoneNumber, age, gender, medicalHistory, prefferedSpecialist, medicineFee,patientType);
		this.admissionFees = admissionFees;
		this.treatment = treatment;
		this.roomType = roomType;
		this.wantFood = wantFood;
	}
	public InPatient() {
		// TODO Auto-generated constructor stub
	}
	public String getAdmissionFees() {
		return admissionFees;
	}
	public void setAdmissionFees(String admissionFees) {
		this.admissionFees = admissionFees;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getWantFood() {
		return wantFood;
	}
	public void setWantFood(String wantFood) {
		this.wantFood = wantFood;
	}
	
}
