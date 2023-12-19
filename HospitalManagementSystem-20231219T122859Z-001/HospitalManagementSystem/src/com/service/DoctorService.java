package com.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.management.DoctorManagement;
import com.model.Doctor;
import com.util.ApplicationUtil;

public class DoctorService {
	ApplicationUtil auObj=new ApplicationUtil();
	DoctorManagement dmObj=new DoctorManagement();
	public List<Doctor> addDoctorList(String[] doctor) throws ParseException {
		// TODO Auto-generated method stub
			List<String> extract=auObj.extractDetails(doctor);
			
			List<Doctor>buildList=buildList(extract);
			List<Doctor>docList=new ArrayList<Doctor>();
			
				docList=dmObj.insertIntoDb(buildList);
		
		return docList;
	}
	public List<Doctor> buildList(List<String> extract) {
		// TODO Auto-generated method stub
		List<Doctor> dList=new ArrayList<Doctor>();
		for(String s:extract) {
			String arr[]=s.split("/");
			String doctorId=generateDoctorId();
			String doctorName=arr[0];
			String doctorFee=arr[1];
			String specilization=arr[2];
			String availableDate=arr[3];
			String availableTime=arr[4];
			Doctor dObj=new Doctor(doctorId, doctorName, doctorFee, specilization, availableDate, availableTime);
			dList.add(dObj);
		}
		return dList;
	}
	static int a=1;
	public String generateDoctorId() {
		// TODO Auto-generated method stub
		String id="DOC00";
	String gen= id+String.valueOf(a);
	a++;
	return gen;
	}
	public int updateDoctorFee(String id, double fee) {
		// TODO Auto-generated method stub
		int result=dmObj.updateFeeInDb(id,fee);
		return result;
	}
	public int updateAvailableDate(String id, String date) throws ParseException {
		// TODO Auto-generated method stub
		int result=dmObj.updateDateInDb(id,date);
		return result;
	}
	public List<Doctor> retriveDetails(String id) {
		// TODO Auto-generated method stub
		List<Doctor>retrived=dmObj.retriveFromDb(id);
		return retrived;
	}
	public int deleteDetails(String id) {
		// TODO Auto-generated method stub
		int result=dmObj.deleteFromDb(id);
		return result;
	}

}
