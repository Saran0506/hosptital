package com.service;

import java.util.ArrayList;

import java.util.List;

import com.management.OutPatientManagement;
import com.model.OutPatient;
import com.util.ApplicationUtil;

public class OutPatientService {
	ApplicationUtil aObj=new ApplicationUtil();
	OutPatientManagement outObj=new OutPatientManagement();
			public List<OutPatient> addPatient(String[] input){
				
				
				List<String> utilExtract=new ArrayList<String>();
				utilExtract=aObj.extractDetails(input);
				
				List<OutPatient>buildObj =new ArrayList<OutPatient>();
				buildObj=buildPatient(utilExtract);
				
				
				List<OutPatient>resultObj =new ArrayList<OutPatient>();
				resultObj=outObj.insertIntoDb(buildObj);
				return resultObj ;
			}
			public List<OutPatient> buildPatient(List<String> input){
				List<OutPatient> oPlist=new ArrayList<OutPatient>();
				int count1=0;
				for(String i:input) {
					count1++;
					String seperate[]=i.split(":");
					String patientId=generateId(count1);
					String patientName=seperate[0];
					String phoneNumber=seperate[1];
					String age=seperate[2];
					String gender=seperate[3];
					String medicalHistory=seperate[4];
					String prefferedSpecialist=seperate[5];
					String medicineFee=seperate[6];
					String patientType=seperate[7];
					String registrationFees=seperate[8];
					OutPatient outpatientObj=new OutPatient(patientId, patientName, phoneNumber, age, gender, medicalHistory, prefferedSpecialist, medicineFee, patientType, registrationFees);
					oPlist.add(outpatientObj);
				}
				return oPlist;
			}
			public List<OutPatient> retrivePatient(String id){
				  List<OutPatient> retrived=outObj.retriveFromDb(id);
				  return retrived;
				
			}
			int count=0;
			public String generateId(int count1) {
				// TODO Auto-generated method stub
				String id="OP00";
				String patientId=outObj.checkIdExist();
				if(patientId=="")
				{
					count++;
					return id+count;
				}
				else if(count1==1) {
					count=Integer.parseInt(patientId.substring(4));
					count++;
					return id+count;
			}
				else {
					count++;
					return id+count;
				}
			}
			public int updatePhoneNumber(String id, long phoneNumber) {
				// TODO Auto-generated method stub
				int updated=outObj.updateToDb(id,phoneNumber);
				
				return updated;
			}
			public int deletePatient(String id) {
				int deleted=outObj.deleteFromDb(id);
				// TODO Auto-generated method stub
				return deleted;
			}
}
