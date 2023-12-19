package com.service;

import java.util.ArrayList;
import java.util.List;
import com.management.InPatientManagement;
import com.model.InPatient;
import com.util.ApplicationUtil;

public class InPatientService {
	ApplicationUtil aObj=new ApplicationUtil();
	InPatientManagement imObj=new InPatientManagement();
	public List<InPatient> addPatient(String[] patient) {
		// TODO Auto-generated method stub
		List<String> extracted=new ArrayList<String>();
		extracted=aObj.extractDetails(patient);
		List<InPatient> buildList=new ArrayList<InPatient>();
		buildList=buildPatient(extracted);
		List<InPatient> inPatientList=new ArrayList<InPatient>();
		inPatientList=imObj.insertIntoDb(buildList);
		return inPatientList;
	}
	private List<InPatient> buildPatient(List<String> extracted) {
		// TODO Auto-generated method stub
		List<InPatient> inPatientList=new ArrayList<InPatient>();
		int count1=0;
		for(String s:extracted) {
			count1++;
			String arr[]=s.split(":");
			String patientId=generateId(count1);
			String patientName=arr[0];
			String phoneNumber=arr[1];
			String age=arr[2];
			String gender=arr[3];
			String medicalHistory=arr[4];
			String prefferedSpecialist=arr[5];
			String medicineFee=arr[6];
			String patientType=arr[7];
			String admissionFees=arr[8];
			String treatment=arr[9];
			String roomType=arr[10];
			String wantFood=arr[11];
			InPatient iObj=new InPatient(patientId, patientName, phoneNumber, age, gender, medicalHistory, prefferedSpecialist, medicineFee, patientType, admissionFees, treatment, roomType, wantFood);
			inPatientList.add(iObj);
		}
		return inPatientList;
	}
	int count=0;
	public String generateId(int count1) {
		// TODO Auto-generated method stub
		String ipId="IP00";
		String patientId=imObj.checkIdExist();
		if(patientId=="")
		{
			count++;
			return ipId+count;
		}
		else if(count1==1) {
			count=Integer.parseInt(patientId.substring(4));
			count++;
			return ipId+count;
	}
		else {
			count++;
			return ipId+count;
		}
	}
	public int updatePhoneNumber(String id, long phoneNumber) {
		// TODO Auto-generated method stub
		int result=imObj.updateDb(id, phoneNumber);
		return result;
	}
	public List<InPatient> retrivePatient(String id){
		  List<InPatient> retrived=imObj.retriveFromDb(id);
		  return retrived;
		
	}
	public int deletePatient(String id1) {
		// TODO Auto-generated method stub
		int result=imObj.deleteFromDb(id1);
		return result;
	}
	public int updateRoomType(String id, String roomType) {
		// TODO Auto-generated method stub
		int result=imObj.updateRoomFromDB(id,roomType);
		return result;
	}
	public int updateFoodPreference(String id, String food) {
		// TODO Auto-generated method stub
		int result=imObj.updateFoodFromDB(id,food);
		return result;
	}

}
