package com.management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.model.Appointment;
import com.model.Doctor;
import com.util.ApplicationUtil;

public class AppointmentManagement {
ApplicationUtil auObj=new ApplicationUtil();
	public List<Doctor> retriveDoctor(String spl) {
		// TODO Auto-generated method stub
		List<Doctor>retrivedList=new ArrayList<Doctor>();
		try {
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement psd=con.prepareStatement("select DOCTOR_ID,DOCTOR_NAME,SPECIALIZATION,AVAILABLE_DATE,AVAILABLE_TIME FROM doctor WHERE SPECIALIZATION=?");
			psd.setString(1, spl);
			ResultSet rs=psd.executeQuery();
			while(rs.next()) {
				Doctor dObj=new Doctor(rs.getString(1),rs.getString(2),rs.getString(3),auObj.convertDateToString(rs.getDate(4)),auObj.convertTimeToString(rs.getTime(5)));
				retrivedList.add(dObj);
			}
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		return retrivedList;
	}
	public List<Appointment> insertIntoDb(List<Appointment> apList) {
		// TODO Auto-generated method stub
		List<Appointment>insertList=new ArrayList<Appointment>();
		try {
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement psd=con.prepareStatement("insert into appointment values(?,?,?,?,?,?,?,?)");
			for(Appointment a:apList) {
				psd.setString(1, a.getAppointmentId());
				psd.setString(2, a.getPatientId());
				psd.setString(3, a.getDoctorId());
				psd.setString(4, a.getDoctorName());
				psd.setString(5, a.getSpecialization());
				psd.setDate(6, auObj.dateConvert(a.getAppointmentDate()));
				psd.setTime(7, auObj.timeConvert(a.getAppointmentTime()));
				psd.setString(8, a.getModeOfAppointment());
				psd.execute();
				insertList.add(a);
			}
		} catch (ClassNotFoundException | SQLException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return insertList;
	}
	public int checkIdFromDB(String id) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement psd=con.prepareStatement("select APPOINTMENT_ID from appointment where APPOINTMENT_ID=?");
			psd.setString(1, id);
			ResultSet rs=psd.executeQuery();
			while(rs.next()) {
				String appId=rs.getString(1);
				if(appId.equals(id)) {
					result=1;
				}
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return result;
	}
	public List<Appointment> retriveAppointmentfromDB(String id) {
		// TODO Auto-generated method stubC
		List<Appointment>apList=new ArrayList<Appointment>();
		try {
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement psd=con.prepareStatement("select * from appointment where PATIENT_ID=?");
			psd.setString(1, id);
			ResultSet rs=psd.executeQuery();
			while(rs.next()) {
				String appointmentId=rs.getString(1);
				String patientId=rs.getString(2);
				String doctorId=rs.getString(3);
				String doctorName=rs.getString(4);
				String specialization=rs.getString(5);
				String appointmentDate=auObj.convertDateToString(rs.getDate(6));
				String appointmentTime=auObj.convertTimeToString(rs.getTime(7));
				String modeOfAppointment=rs.getString(8);
				Appointment aObj=new Appointment(appointmentId, patientId, doctorId, doctorName, specialization, appointmentDate, appointmentTime, modeOfAppointment);
				apList.add(aObj);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return apList;
	}
	public int deleteFromDB(String id) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement psd=con.prepareStatement("delete  from appointment where PATIENT_ID=?");
			psd.setString(1, id);
			result=psd.executeUpdate();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		return result;
	}
	public  String checkIdExist() 
	{
		String appointmentId="";
		try 
		{
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement("select APPOINTMENT_ID from appointment order by APPOINTMENT_ID desc limit 1");
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				appointmentId=rs.getString(1);
			}
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		return appointmentId;
	}
}
