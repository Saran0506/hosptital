package com.model;

public class OutPatient extends Patient {
	
	private String registrationFees;

	public String getRegistrationFees() {
		return registrationFees;
	}

	public void setRegistrationFees(String registrationFees) {
		this.registrationFees = registrationFees;
	}

	public OutPatient(String patientId, String patientName, String phoneNumber, String age, String gender,
			String medicalHistory, String prefferedSpecialist, String medicineFee, String patientType,
			String registrationFees) {
		super(patientId, patientName, phoneNumber, age, gender, medicalHistory, prefferedSpecialist, medicineFee,
				patientType);
		this.registrationFees = registrationFees;
	}
//
//	public OutPatient() {
//		// TODO Auto-generated constructor stub
//	}

	public OutPatient() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
