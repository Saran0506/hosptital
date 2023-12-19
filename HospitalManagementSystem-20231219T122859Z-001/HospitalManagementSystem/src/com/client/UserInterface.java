package com.client;
import java.text.ParseException;
import java.util.*;

import com.model.Allocation;
import com.model.Appointment;
import com.model.Doctor;
import com.model.InPatient;
import com.model.OutPatient;
import com.model.Payment;
import com.service.AllocationService;
import com.service.AppointmentService;
import com.service.DoctorService;
import com.service.InPatientService;
import com.service.OutPatientService;
import com.service.PaymentService;
public class UserInterface {

	public static void main(String[] args) {
		try (//		
		//				Connection con= DBConnectionManager.getConnection();
		Scanner sc = new Scanner(System.in)) {
			{
				int choice=0;
				OutPatientService oObj=new OutPatientService();
				InPatientService iObj=new InPatientService();
				System.out.println("_______________________________________\n     Apollo Hospital Management     \n_______________________________________");
				do {
					System.out.println("\nEnter the choice\n1.OutPatient\n2.InPatient\n3.Doctor\n4.Appointment\n5.Allocation\n6.Payment\n7.Exit");
					choice=sc.nextInt();
					switch (choice){
					case 1: {
							char pChoice=0;
							System.out.println("Enter the choice(A-E)\nA.Generate OutPatient details\nB.Update OutPatient Phone Number\nC.Retrive OutPatient Details\nD.Delete OutPatient Details\nE.Exit");
							 pChoice=sc.next().charAt(0);
							while(pChoice=='A'||pChoice=='B'||pChoice=='C'||pChoice=='D') {
								 if(pChoice=='A') {
									 System.out.println("Enter the number of Outpatient details to Generate");
									 int size=sc.nextInt();
									 System.out.println("Enter the details\nInput format::PatientName:PhoneNumber:Age:Gender:MedicalHistory:PreferredSpecialist:MedicineFee:"
									 		+ "PatientType:RegistrationFees");
									 String patient[]=new String[size];
									 for(int i=0;i<size;i++) {
										 sc.nextLine();
										 patient[i]=sc.next();
									 }
									 List<OutPatient> output=oObj.addPatient(patient);
									 if(output.isEmpty()==true) {
										 System.out.println(" OutPatient Details not  Generated");
									 }
//								 else if (output.size()<size) {
//									 System.out.println("only "+output.size()+" Patients are added");
//								 }
									 else {
										 System.out.println(output.size()+" OutPatient Details Generated succesfully!");
										 for(OutPatient i:output) {
											 System.out.println(i.getPatientName()+"'s Patient id is : "+i.getPatientId());
										 }
									 }
								 }
								 if(pChoice=='B') {
									 System.out.println("Enter patient id");
									 String id=sc.next();
									 System.out.println("Enter phone number to be update");
									 long phoneNumber=sc.nextLong();
									 int updatedPhoneNumber=oObj.updatePhoneNumber(id,phoneNumber);
									 if(updatedPhoneNumber==1) {
										 System.out.println("Phone number updated successfully!");
									 }
									 else {
										 System.out.println(phoneNumber+" is not updated");
									 }
								 }
									 if (pChoice=='C'){
										 {
											 System.out.println("Enter patient id");
											 String id1=sc.next();
											 List<OutPatient>retrivedList=oObj.retrivePatient(id1);
											 if(retrivedList.isEmpty()) {
												 System.out.println("The details are not available");
											 }
											 else {
												for(OutPatient o:retrivedList) {
													System.out.println("----------------------------------------\nPatientId           :"+o.getPatientId()+"\nPatientName         :"+o.getPatientName()+"\nPhoneNumber         :"+o.getPhoneNumber()+"\nAge                 :"+o.getAge()+"\nGender              :"+o.getGender()+"\nMedicalHistory      :"+o.getMedicalHistory()+"\nPreferredSpecialist :"+o.getPrefferedSpecialist()+"\nMedicineFee         :"+o.getMedicineFee()+"\nPatientType         :"+o.getPatientType()+"\nRegistrationFees    :"+o.getRegistrationFees()+"\n----------------------------------------");
												}
											 }
									 }
										
									}
									 if(pChoice=='D') {
										 System.out.println("Enter patient id");
										 String id1=sc.next();
										 int delete=oObj.deletePatient(id1);
										 if(delete==1) {
											 System.out.println("Patient details deleted succesfully!");
										 }
										 else {
											 System.out.println("Patient details cannot be deleted");
										 }
									 }
									 System.out.println("Enter the choice(A-E)\nA.Generate OutPatient details\nB.Update OutPatient Phone Number\nC.Retrive OutPatient Details\nD.Delete OutPatient Details\nE.Exit");
									 pChoice=sc.next().charAt(0);
							}
					break;
					}
					case 2:{
						char pChoice=0;
						System.out.println("Enter the choice(A-G)\nA.Generate InPatient details\nB.Update InPatient Phone Number\nC.Update Inpatient Room Type\nD.Update Inpatient Food Preference\nE.Retrive InPatient Details\nF.Delete InPatient Details\nG.Exit");
						 pChoice=sc.next().charAt(0);
						while(pChoice=='A'||pChoice=='B'||pChoice=='C'||pChoice=='D'||pChoice=='E'||pChoice=='F') {
							
							 if(pChoice=='A') {
								 System.out.println("Enter the number of Inpatient details to Generate");
								 int size=sc.nextInt();
								 System.out.println("Enter the details\nInput format::PatientName:PhoneNumber:Age:Gender:MedicalHistory:PreferredSpecialist:MedicineFee:Patient Type:Admission Fees:Treatment:Room Type:Want Food");
								 String patient[]=new String[size];
								 for(int i=0;i<size;i++) {
									 sc.nextLine();
									 patient[i]=sc.next();
								 }
								 List<InPatient> output=iObj.addPatient(patient);
								 if(output.isEmpty()==true) {
									 System.out.println(" Inpatient Details not  Generated");
								 }
//							 else if (output.size()<size) {
//								 System.out.println("only "+output.size()+" Patients are added");
//							 }
								 else {
									 System.out.println(output.size()+" InPatient Details Generated succesfully!");
									 for(InPatient ip:output) {
										 System.out.println(ip.getPatientName()+"'s Patient ID is : "+ip.getPatientId());
									 }
								 }
							 }
							 if(pChoice=='B') {
								 System.out.println("Enter patient id");
								 String id=sc.next();
								 System.out.println("Enter phone number to be update");
								 long phoneNumber=sc.nextLong();
								 int updatedPhoneNumber=iObj.updatePhoneNumber(id,phoneNumber);
								 if(updatedPhoneNumber==1) {
									 System.out.println("Phone number updated successfully!");
								 }
								 else {
									 System.out.println(phoneNumber+" is not updated");
								 }
							 }
							 if(pChoice=='C') {
								 System.out.println("Enter patient id");
								 String id=sc.next();
								 System.out.println("Enter Room Type to be update");
								 String roomType=sc.next();
								 int updatedRoomType=iObj.updateRoomType(id,roomType);
								 if(updatedRoomType!=0) {
									 System.out.println("InPatient Room Type updated successfully");
								 }
								 else {
									 System.out.println("InPatient Room Type not updated successfully");
								 }
							 }
							 if(pChoice=='D') {
								 System.out.println("Enter patient id");
								 String id=sc.next();
								 System.out.println("Enter Food Preference to be update");
								 String food=sc.next();
								 int updatedFood=iObj.updateFoodPreference(id,food);
								 if(updatedFood!=0) {
									 System.out.println("Inpatient Food Preference updated successfully");
								 }
								 else {
									 System.out.println("Inpatient Food Preference is not updated");
								 }
							 }
								 if (pChoice=='E'){
									 {
										 System.out.println("Enter patient id");
										 String id1=sc.next();
										 List<InPatient>retrivedList=iObj.retrivePatient(id1);
										 if(retrivedList.isEmpty()) {
											 System.out.println("The details are not available");
										 }
										 else {
											for(InPatient o:retrivedList) {
												System.out.println("--------------------------------------------\nPatientId           :"+o.getPatientId()+"\nPatientName         :"+o.getPatientName()+"\nPhoneNumber         :"+o.getPhoneNumber()+"\nAge                 :"+o.getAge()+"\nGender              :"+o.getGender()+"\nMedicalHistory      :"+o.getMedicalHistory()+"\nPreferredSpecialist :"+o.getPrefferedSpecialist()+"\nMedicineFee         :"+o.getMedicineFee()+"\nPatientType         :"+o.getPatientType()+"\nAdmissionFees       :"+o.getAdmissionFees()+"\nTreatment           :"+o.getTreatment()+"\nRoomType            :"+o.getRoomType()+"\nWantFood            :"+o.getWantFood()+"\n-------------------------------------------");											}
										 }
								 }
									
								}
								 if(pChoice=='F') {
									 System.out.println("Enter patient id");
									 String id1=sc.next();
									 int delete=iObj.deletePatient(id1);
									 if(delete==1) {
										 System.out.println("Patient details deleted succesfully!");
									 }
									 else {
										 System.out.println("Patient details cannot be deleted");
									 }
								 }
								 
									System.out.println("Enter the choice(A-G)\nA.Generate InPatient details\nB.Update InPatient Phone Number\nC.Update Inpatient Room Type\nD.Update Inpatient Food Preference\nE.Retrive InPatient Details\nF.Delete InPatient Details\nG.Exit");
									 pChoice=sc.next().charAt(0);
						}
						break;
//						while(pChoice!=5);
					}
					case 3:{
						char pChoice=0;
						System.out.println("Enter the choice(A-F)\nA.Generate Doctor details\nB.Update Doctor Fee\nC.Update Doctor Available Date\nD.Retrieve Doctor Details\nE.Delete Doctor Details\nF.Exit");
						 pChoice=sc.next().charAt(0);
						 DoctorService dsObj=new DoctorService();
						 while(pChoice=='A'||pChoice=='B'||pChoice=='C'||pChoice=='D'||pChoice=='E')  {
							if(pChoice=='A') {
								System.out.println("How many Doctor details to Generate");
								int doc=sc.nextInt();
								System.out.println("Enter the details \nInput format :Doctor Name/Doctor Fee/Specialization/Available Date(yyyy-MM-dd)/Available Time(HH:MM:SS)");
								String[] doct=new String[doc];
								for(int i=0;i<doc;i++) {
									
									sc.nextLine();
									doct[i]=sc.next();
								}
								
								List<Doctor> docList=new ArrayList<Doctor>();
								docList=dsObj.addDoctorList(doct);
								if(docList.isEmpty()) {
									System.out.println("Doctor Details not Generated");
								}
								else {
									for(Doctor d:docList) {
										System.out.println(d.getDoctorName()+"'s ID: "+d.getDoctorId());
									}
								}
								
							}
							if(pChoice=='B') {
								System.out.println("Enter Doctor Id");
								sc.nextLine();
								String id=sc.next();
								System.out.println("Enter the fee to be Update");
								double fee=sc.nextDouble();
								int result=dsObj.updateDoctorFee(id,fee);
								if(result==1) {
									System.out.println("Doctor Fee Updated Succesfully");
								}
								else {
									System.out.println("Doctor Fee not updated");
								}
							}
							if(pChoice=='C') {
								System.out.println("Enter Doctor Id");
								String id=sc.next();
								System.out.println("Enter Available Date to be updated");
								String date=sc.next();
								int result=dsObj.updateAvailableDate(id,date);
								if(result==1) {
									System.out.println("Available Date updated successfully");
								}
								else {
									System.out.println("Available date not updated");
								}
							}
							if(pChoice=='D') {
								System.out.println("Enter Doctor Id");
								String id=sc.next();
								List<Doctor>dcList=dsObj.retriveDetails(id);
								if(dcList.isEmpty()) {
									System.out.println("Details are not available");
								}
								else {
									for(Doctor d:dcList) {
										System.out.println("-------------------------------------------\nDoctor ID          : "+d.getDoctorId()+"\nDoctor Name        : "+d.getDoctorName()+"\nDoctor Fee         : "+d.getDoctorFee()+"\nSpecialization     : "+d.getSpecialization()+"\nAvailable Date     : "+d.getAvailableDate()+"\nAvailable Time     : "+d.getAvailableTime()+"\n----------------------------------------");
									}
								}
							}
							if(pChoice=='E') {
								System.out.println("Enter Doctor Id");
								String id=sc.next();
								int result=dsObj.deleteDetails(id);
								if(result==1) {
									System.out.println("Doctor Details deleted successfully");
								}
								else {
									System.out.println("Doctor details not deleted");
								}
							}
							System.out.println("Enter the choice(A-F)\nA.Generate Doctor details\nB.Update Doctor Fee\nC.Update Doctor Available Date\nD.Retrieve Doctor Details\nE.Delete Doctor Details\nF.Exit");
							 pChoice=sc.next().charAt(0);
						}
						 break;
					}
					case 4:{
						char pChoice=0;
						System.out.println("Enter Your Choice(A-F)\nA.Generate Appoinment details\nB.Retrive Doctor details for Specialization\nC.Check Appointment ID exist\nD.Retrive Appointment Details\nE.Delete AppointMent Details\nF.Exit");
						pChoice=sc.next().charAt(0);
						AppointmentService asObj=new AppointmentService();
						while(pChoice=='A'||pChoice=='B'||pChoice=='C'||pChoice=='D'||pChoice=='E') {
							if(pChoice=='A') {
								System.out.println("How many appointments to be Generate");
								int aSize=sc.nextInt();
								System.out.println("Enter Appointment details:");
								System.out.println("Input format: Patient ID:Specialization:Mode of Appointment");
								String appoint[]=new String[aSize];
								sc.nextLine();
								for(int i=0;i<aSize;i++) {
									appoint[i]=sc.next();
								}
								List<Appointment>apList=asObj.addAppointment(appoint);
								if(apList.isEmpty()) {
									System.out.println("Appointment details not Generated");
								}
								else {
									System.out.println("Appointment details Generated successfully");
									for(Appointment a:apList) {
										System.out.println("Appointment ID is : "+a.getAppointmentId());
									}
						}
						
							}
							if(pChoice=='B') {
								System.out.println("Enter Specialization");
								String spec=sc.next();
								List<Doctor>dcList=asObj.retriveDoctor(spec);
								if(dcList.isEmpty()) {
									System.out.println("Doctor not available for this specialization");
								}
								else {
									System.out.println("------------------------------\nList of Doctors");
									int i =1;
									for(Doctor d:dcList) {
										System.out.println(i+"."+d.getDoctorName());
										i++;
									}
									System.out.println("------------------------------");
								}
							}
							if(pChoice=='C') {
								System.out.println("Enter Appointment ID");
								String id=sc.next();
								int result=asObj.checkId(id);
								if(result==1) {
									System.out.println("Appointment ID Exist");
								}
								else {
									System.out.println("Appointment ID does not exist");
								}
							}
							if(pChoice=='D') {
								System.out.println("Enter Patient ID");
								String id=sc.next();
								List<Appointment>apList=asObj.retriveAppointment(id);
								if(apList.isEmpty()) {
									System.out.println("Appointment details not available");
								}
								else {
									for(Appointment a:apList) {
										System.out.println("-------------------------------------------\n1.Appointment ID          : "+a.getAppointmentId()+"\n2.Patient ID              : "+a.getPatientId()+"\n3.Doctor ID               : "+a.getDoctorId()+"\n4.Doctor Name             : "+a.getDoctorName()+"\n5.Specialization          : "+a.getSpecialization()+"\n6.Appointment Date        : "+a.getAppointmentDate()+"\n7.Appointment Time        : "+a.getAppointmentTime()+"\n8.Mode of Appointment     : "+a.getModeOfAppointment()+"\n--------------------------------------------");
									}
								}
							}
							if(pChoice=='E') {
								System.out.println("Enter Patient ID");
								String id=sc.next();
								int result=asObj.deletePatient(id);
								if(result>0) {
									System.out.println("Appointment details deleted successfully");
								}
								else {
									System.out.println("Appointment details not deleted");
								}
							}
							System.out.println("Enter Your Choice(A-F)\nA.Generate Appoinment details\nB.Retrive Doctor details for Specialization\nC.Check Appointment ID exist\nD.Retrive Appointment Details\nE.Delete AppointMent Details\nF.Exit");
							pChoice=sc.next().charAt(0);
						}
						break;
					}
					case 5:{
						char pChoice=0;
						AllocationService asObj=new AllocationService();
						System.out.println("Enter Your Choice(A-E)\nA.Generate Allocation Details\nB.Check Allocation ID Exist \nC.Retrive Allocation Details\nD.Delete Allocation details\nE.Exit");
						pChoice=sc.next().charAt(0);
						while(pChoice=='A'||pChoice=='B'||pChoice=='C'||pChoice=='D') {
							if(pChoice=='A') {
								System.out.println("How many Allocation details to Generate");
								int aSize=sc.nextInt();
								String alloc[]=new String[aSize];
								System.out.println("Enter the details\nInput format: Patient ID:Room number:No of days admitted:Admission Date(yyyy-MM-dd):Discharge Date(yyyy-MM-dd)");
								sc.nextLine();
								for(int i=0;i<aSize;i++) {
									alloc[i]=sc.next();
								}
								List<Allocation>aList=asObj.addAllocation(alloc);
								if(aList.isEmpty()) {
									System.out.println("Allocation details not Generate ");
								}
								else {
									System.out.println("Allocation details Generate successfully");
									for(Allocation a:aList) {
										System.out.println("Allocation ID : "+a.getAllocationId());
									}
								}
							}
							if(pChoice=='B') {
								System.out.println("Enter Allocation ID");
								String id=sc.next();
								int result=asObj.checkId(id);
								if(result!=0) {
									System.out.println("Allocation ID Exist");
								}
								else {
									System.out.println("Allocation ID does not Exist");
								}
							}
							if(pChoice=='C') {
								System.out.println("Enter Patient ID");
								String id=sc.next();
								List<Allocation>aList=asObj.retriveList(id);
								if(aList.isEmpty()) {
									System.out.println("Patient Details not available");
								}
								else {
									System.out.println("Patient Details");
									for(Allocation a:aList) {
										System.out.println("----------------------------------------\n1.Allocation ID           : "+a.getAllocationId()+"\n2.Patient ID              : "+a.getPatientId()+"\n3.Room Number             : "+a.getRoomNumber()+"\n4.No of days Admitted     : "+a.getNoOfDaysAdmitted()+"\n5.Admission Date          : "+a.getAdmissionDate()+"\n6.Discharge Date          : "+a.getDischargeDate()+"\n7.Treatment               : "+a.getTreatment()+"\n8.Room Type               : "+a.getRoomType()+"\n9.Want Food               : "+a.getWantFood()+"\n----------------------------------------");
									}
								}
							}
							if(pChoice=='D') {
								System.out.println("Enter Patient ID");
								String id=sc.next();
								int result=asObj.deleteList(id);
								if(result!=0) {
									System.out.println("Allocation details deleted successfully");
								}
								else {
									System.out.println("Allocation details does not deleted");
								}
							}
							System.out.println("Enter Your Choice(A-E)\nA.Generate Allocation Details\nB.Check Allocation ID Exist \nC.Retrive Allocation Details\nD.Delete Allocation details\nE.Exit");
							pChoice=sc.next().charAt(0);
						}
						break;
					}
					case 6:{
						char pChoice=0;
						PaymentService psObj=new PaymentService();
						System.out.println("Enter your choice(A-C) \nA.Generate Payment Details\nB.Retrive Payment Details\nC.Exit");
						pChoice=sc.next().charAt(0);
						while(pChoice=='A'||pChoice=='B') {
							if(pChoice=='A') {
								System.out.println("How many Payment details to be generate");
								int count=sc.nextInt();
								sc.nextLine();
								System.out.println("Enter details\nInput format: Patient ID:Patient Type:Payment Date:mode of Payment");
								String pay[]=new String[count];
								for(int i=0;i<count;i++) {
									pay[i]=sc.next();
								}
								
								List<Payment>paymentList=psObj.addPaymentList(pay);
								if(paymentList.isEmpty()) {
									System.out.println("Payment details cannot be generate");
								}
								else {
									System.out.println("Payment details generate successfully");
									for(Payment p:paymentList) {
										System.out.println(p.getPatientName()+" 's Payment ID     : "+p.getPaymentId()+"\nBill Amount              : "+p.getBillAmount());
									}
								}
							}
							if(pChoice=='B') {
								System.out.println("Enter Patient ID");
								String id=sc.next();
								List<Payment>paymentList=psObj.retriveList(id);
								if(paymentList.isEmpty()) {
									System.out.println("No Payment Details Available");
								}
								else {
									System.out.println("Payment Details");
									for(Payment p:paymentList) {
										System.out.println("----------------------------------------\n1.Payment ID              : "+p.getPaymentId()+"\n2.Patient ID              : "+p.getPatientId()+"\n3.Patient Name            : "+p.getPatientName()+"\n4.Patient Type            : "+p.getPatientType()+"\n5.Payment Date            : "+p.getPaymentDate()+"\n6.Mode Of Payment         : "+p.getModeOfPayment()+"\n7.Bill Amount             : "+p.getBillAmount()+"\n----------------------------------------");
									}
								}
							}
							System.out.println("Enter your choice(A-C) \nA.Generate Payment Details\nB.Retrive Payment Details\nC.Exit");
							pChoice=sc.next().charAt(0);
						}break;
					}
					case 7:{
						System.out.println("----------------------------------------\nThank You For Using This Application\n----------------------------------------");
						return;
					}
				}
			}while(choice!=0);
}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
//Sudharsan:300:ortho:22/11/2023:12:10		
				 
 