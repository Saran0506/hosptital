package com.service;

import java.util.ArrayList;
import java.util.List;

import com.management.AllocationManagement;
import com.management.AppointmentManagement;
import com.management.DoctorManagement;
import com.management.InPatientManagement;
import com.management.OutPatientManagement;
import com.management.PaymentManagement;
import com.model.Allocation;
import com.model.Appointment;
import com.model.InPatient;
import com.model.OutPatient;
import com.model.Payment;
import com.util.ApplicationUtil;

public class PaymentService {
ApplicationUtil auObj=new ApplicationUtil();
PaymentManagement pmObj=new PaymentManagement();
	public List<Payment> addPaymentList(String[] pay) {
		// TODO Auto-generated method stub
		List<String>extract=auObj.extractDetails(pay);
		List<Payment>build=buildList(extract);
		List<Payment>resultList=pmObj.insertIntoDB(build);
		return resultList;
	}
	public List<Payment> buildList(List<String> extract) {
		// TODO Auto-generated method stub
		List<Payment>buildList=new ArrayList<Payment>();
		int count1=0;
		for(String s:extract) {
			count1++;
			String details[]=s.split(":");
			if(details[1].equalsIgnoreCase("INPATIENT")) {
				InPatientManagement imObj=new InPatientManagement();
				List<InPatient>ipList=imObj.retriveFromDb(details[0]);
				for(InPatient i:ipList) {
					AllocationManagement amObj=new AllocationManagement();
					List<Allocation>aList=amObj.retriveFromDB(i.getPatientId());
					for(Allocation a:aList) {
						Payment pObj=new Payment(generateId(count1), i.getPatientId(),i.getPatientName(), i.getPatientType(), details[2], details[3],calculateBillAmountForInpatient(i.getTreatment(),i.getRoomType(),i.getWantFood(),i.getAdmissionFees(),i.getMedicineFee(),a.getNoOfDaysAdmitted()) );
						buildList.add(pObj);
					}
					
				}
				
			}      
			else if(details[1].equalsIgnoreCase("OUTPATIENT")) {
				OutPatientManagement omObj=new OutPatientManagement();
				List<OutPatient>opList=omObj.retriveFromDb(details[0]);
				for(OutPatient o:opList) {
					AppointmentManagement amObj=new AppointmentManagement();
					List<Appointment>apList=amObj.retriveAppointmentfromDB(o.getPatientId());
					for(Appointment a:apList) {
						DoctorManagement dmObj=new DoctorManagement();
						String doctorFee=dmObj.getDoctorFee(a.getDoctorId());
						Payment pObj=new Payment(generateId(count1),o.getPatientId(),o.getPatientName() ,o.getPatientType(), details[2], details[3], calculateBillAmountForOutpatient(doctorFee,o.getMedicineFee(),o.getRegistrationFees()));
						buildList.add(pObj);
					}
				}
			}
		}
		return buildList;
	}
	public String calculateBillAmountForOutpatient(String doctorFee, String medicineFee, String registrationFees) {
		// TODO Auto-generated method stub
		Double bill=Double.parseDouble(doctorFee)+Double.parseDouble(medicineFee)+Double.parseDouble(registrationFees);
		return auObj.convertDoubleToString(bill);
	}
	public String calculateBillAmountForInpatient(String treatment, String roomType, String wantFood,String admissionFees,String medicineFee,
			String noOfDaysAdmitted) {
		// TODO Auto-generated method stub 
		Double bill;
		Double treatmentCost;
		Double room;
		Double food;
		if(roomType.equalsIgnoreCase("private")) {
			room=500.00;
		}
		else if(roomType.equalsIgnoreCase("semi-private")) {
			room=400.00;
		}
		else {
			room=300.00;
		}
		if(wantFood.equalsIgnoreCase("yes")) {
			food=150.00;
		}
		else {
			food=0.00;
		}
		if(treatment.equalsIgnoreCase("surgery")) {
			treatmentCost=20000.00;
		}
		else if(treatment.equalsIgnoreCase("general")) {
			treatmentCost=5000.00;
		}
		else {
			treatmentCost=10000.00;
		}
		bill=treatmentCost+(auObj.convertDouble(admissionFees))+auObj.convertDouble(medicineFee)+(auObj.convertDouble(noOfDaysAdmitted)*(room+food));
		
		return auObj.convertDoubleToString(bill);
	}
	int count=0;
	public String generateId(int count1) {
		// TODO Auto-generated method stub
		String id="PM00";
		String paymentId=pmObj.checkIdExist();
		if(paymentId=="")
		{
			count++;
			return id+count;
		}
		else if(count1==1) {
			count=Integer.parseInt(paymentId.substring(4));
			count++;
			return id+count;
	}
		else {
			count++;
			return id+count;
		}
	}
	public List<Payment> retriveList(String id) {
		// TODO Auto-generated method stub
		List<Payment>paymentList=pmObj.retriveFromDB(id);
		return paymentList;
	}

}
