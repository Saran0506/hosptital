package com.model;

public class Doctor {
     private String doctorId;
     private String doctorName;
     private String doctorFee;
     private String specialization;
     private String availableDate;
     private String availableTime;
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorFee() {
		return doctorFee;
	}
	public void setDoctorFee(String doctorFee) {
		this.doctorFee = doctorFee;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getAvailableDate() {
		return availableDate;
	}
	public void setAvailableDate(String availableDate) {
		this.availableDate = availableDate;
	}
	public String getAvailableTime() {
		return availableTime;
	}
	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}
	public Doctor(String doctorId, String doctorName, String doctorFee, String specialization, String availableDate,
			String availableTime) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorFee = doctorFee;
		this.specialization = specialization;
		this.availableDate = availableDate;
		this.availableTime = availableTime;
	}
	public Doctor(String doctorId, String doctorName, String specialization, String availableDate,
			String availableTime) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.availableDate = availableDate;
		this.availableTime = availableTime;
	}
	
    
     
}
