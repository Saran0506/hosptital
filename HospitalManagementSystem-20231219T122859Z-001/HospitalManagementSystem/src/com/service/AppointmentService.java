package com.service;

import java.util.ArrayList;
import java.util.List;

import com.management.AppointmentManagement;
import com.model.Appointment;
import com.model.Doctor;
import com.util.ApplicationUtil;

public class AppointmentService {
ApplicationUtil auObj=new ApplicationUtil();
AppointmentManagement amObj=new AppointmentManagement();
	public List<Appointment> addAppointment(String []input) {
		// TODO Auto-generated method stub
		List<String>extracted=auObj.extractDetails(input);
		List<Appointment>apList=buildAppointment(extracted);
		List<Appointment>resultList=amObj.insertIntoDb(apList);
		return resultList;
	}
	public List<Appointment> buildAppointment(List<String>extracted) {
		// TODO Auto-generated method stub
		List<Appointment>apList=new ArrayList<Appointment>();
		int count1=0;
		for(String s:extracted) {
			count1++;
			String built[]=s.split(":");
			List<Doctor> dList=amObj.retriveDoctor(built[1]);
			for(Doctor d:dList) {
				Appointment aObj=new Appointment(generateId(count1), built[0],d.getDoctorId(), d.getDoctorName(), d.getSpecialization(), d.getAvailableDate(), d.getAvailableTime(), built[2]);
//				System.out.println(d.getAvailableDate());
				apList.add(aObj);
			}
		}
		
		
		return apList;
	}
	int count=0;
	public String generateId(int count1) {
		// TODO Auto-generated method stub
		String id="APT00";
		String appointmentId=amObj.checkIdExist();
		if(appointmentId=="")
		{
			count++;
			return id+count;
		}
		else if(count1==1) {
			count=Integer.parseInt(appointmentId.substring(5));
			count++;
			return id+count;
	}
		else {
			count++;
			return id+count;
		}
	}
	public List<Doctor> retriveDoctor(String spec) {
		// TODO Auto-generated method stub
		List<Doctor>dList=amObj.retriveDoctor(spec);
		return dList;
	}
	public int checkId(String id) {
		// TODO Auto-generated method stub
		int result=amObj.checkIdFromDB(id);
		return result;
	}
	public List<Appointment> retriveAppointment(String id) {
		// TODO Auto-generated method stub
		List<Appointment>apList=amObj.retriveAppointmentfromDB(id);
		return apList;
	}
	public int deletePatient(String id) {
		// TODO Auto-generated method stub
		int result=amObj.deleteFromDB(id);
		return result;
	}

}
