package com.management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.model.Doctor;
import com.util.ApplicationUtil;

public class DoctorManagement {
ApplicationUtil auObj=new ApplicationUtil();
	public List<Doctor> insertIntoDb(List<Doctor> buildList) throws ParseException {
		// TODO Auto-generated method stub
		List<Doctor>docList=new ArrayList<Doctor>();
		try {
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement psd=con.prepareStatement("insert into doctor values(?,?,?,?,?,?)");
			for(Doctor d:buildList) {
				psd.setString(1, d.getDoctorId());
				psd.setString(2, d.getDoctorName());
				psd.setDouble(3, auObj.convertDouble(d.getDoctorFee()));
				psd.setString(4, d.getSpecialization());
				psd.setDate(5,auObj.dateConvert(d.getAvailableDate()));
				psd.setTime(6, auObj.timeConvert(d.getAvailableTime()));
				psd.execute();
				docList.add(d);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return docList;
	}
	public int updateFeeInDb(String id, double fee) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement psd=con.prepareStatement("update doctor SET DOCTOR_FEE=?  where DOCTOR_ID=?");
			psd.setDouble(1, fee);
			psd.setString(2, id);
			result=psd.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();System.err.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return result;
	}
	public int updateDateInDb(String id, String date)  {
		int result=0;
		// TODO Auto-generated method stub
		try {
			Connection con=DBConnectionManager.getConnection();
//			System.out.println(auObj.dateConvert(date));
			PreparedStatement psd=con.prepareStatement("update doctor set AVAILABLE_DATE=? WHERE DOCTOR_ID=?");
			psd.setDate(1, auObj.dateConvert(date));
			psd.setString(2, id);
			result=psd.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return result;
	}
	public List<Doctor> retriveFromDb(String id) {
		// TODO Auto-generated method stub
		List<Doctor>dcList=new ArrayList<Doctor>();
		try {
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement psd=con.prepareStatement("select * from doctor where DOCTOR_ID=?");
			psd.setString(1, id);
			ResultSet rs=psd.executeQuery();
			while(rs.next()) {
				Doctor dObj=new Doctor(rs.getString(1), rs.getString(2),auObj.convertDoubleToString(rs.getDouble(3)), rs.getString(4), auObj.convertDateToString(rs.getDate(5)), auObj.convertTimeToString(rs.getTime(6)));
				dcList.add(dObj);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return dcList;
	}
	public int deleteFromDb(String id) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement psd=con.prepareStatement("DELETE FROM doctor WHERE DOCTOR_ID=?");
			psd.setString(1, id);
			result=psd.executeUpdate();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return result;
	}
	public String getDoctorFee(String doctorId) {
		// TODO Auto-generated method stub
		String res="";
		try {
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement psd=con.prepareStatement("select DOCTOR_FEE from doctor where DOCTOR_ID=?");
			psd.setString(1, doctorId);
			ResultSet rs=psd.executeQuery();
			while(rs.next()) {
				res=auObj.convertDoubleToString(rs.getDouble(1));
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return res;
	}

	
}
