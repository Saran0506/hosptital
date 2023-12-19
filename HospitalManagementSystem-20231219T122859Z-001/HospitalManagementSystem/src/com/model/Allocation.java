package com.model;

public class Allocation {
	private String allocationId;
	private String patientId;
	private String roomNumber;
	private String noOfDaysAdmitted;
	private String admissionDate;
	private String dischargeDate;
	private String treatment;
	private String roomType;
	private String wantFood;
	public Allocation(String allocationId, String patientId, String roomNumber, String noOfDaysAdmitted,
			String admissionDate, String dischargeDate, String treatment, String roomType, String wantFood) {
		super();
		this.allocationId = allocationId;
		this.patientId = patientId;
		this.roomNumber = roomNumber;
		this.noOfDaysAdmitted = noOfDaysAdmitted;
		this.admissionDate = admissionDate;
		this.dischargeDate = dischargeDate;
		this.treatment = treatment;
		this.roomType = roomType;
		this.wantFood = wantFood;
	}
	public String getAllocationId() {
		return allocationId;
	}
	public void setAllocationId(String allocationId) {
		this.allocationId = allocationId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getNoOfDaysAdmitted() {
		return noOfDaysAdmitted;
	}
	public void setNoOfDaysAdmitted(String noOfDaysAdmitted) {
		this.noOfDaysAdmitted = noOfDaysAdmitted;
	}
	public String getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
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
