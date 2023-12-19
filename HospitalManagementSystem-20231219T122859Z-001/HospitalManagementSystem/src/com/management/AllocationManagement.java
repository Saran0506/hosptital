package com.management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Allocation;
import com.util.ApplicationUtil;

public class AllocationManagement {
ApplicationUtil auObj=new ApplicationUtil();

public List<Allocation> insertIntoDB(List<Allocation> aList) {
	// TODO Auto-generated method stub
	List<Allocation>alList=new ArrayList<Allocation>();
	try {
		Connection con=DBConnectionManager.getConnection();
		PreparedStatement psd=con.prepareStatement("insert into allocation values(?,?,?,?,?,?,?,?,?)");
		for(Allocation a:aList) {
			psd.setString(1, a.getAllocationId());
			psd.setString(2, a.getPatientId());
			psd.setInt(3, auObj.convertInt(a.getRoomNumber()));
			psd.setInt(4, auObj.convertInt(a.getNoOfDaysAdmitted()));
			psd.setDate(5, auObj.dateConvert(a.getAdmissionDate()));
			psd.setDate(6, auObj.dateConvert(a.getDischargeDate()));
			psd.setString(7, a.getTreatment());
			psd.setString(8, a.getRoomType());
			psd.setString(9, a.getWantFood());
			psd.execute();
			alList.add(a);
		}
	} catch (ClassNotFoundException | SQLException | IOException e) {
		// TODO Auto-generated catch block
		System.err.println(e.getMessage());
	}
	return alList;
}

public int checkIDFromDB(String id) {
	// TODO Auto-generated method stub
	int result=0;
	try {
		Connection con=DBConnectionManager.getConnection();
		PreparedStatement psd=con.prepareStatement("select ALLOCATION_ID from allocation where ALLOCATION_ID=?");
		psd.setString(1, id);
		ResultSet rs=psd.executeQuery();
		while(rs.next()) {
			String aId=rs.getString(1);
			if(aId.equals(id)) {
				result=1;
			}
		}
	} catch (ClassNotFoundException | SQLException | IOException e) {
		// TODO Auto-generated catch block
		System.err.println(e.getMessage());
	}
	return result;
}

public List<Allocation> retriveFromDB(String id) {
	// TODO Auto-generated method stub
	List<Allocation>aList=new ArrayList<Allocation>();
	try {
		Connection con=DBConnectionManager.getConnection();
		PreparedStatement psd=con.prepareStatement("select * from allocation where PATIENT_ID=?");
		psd.setString(1, id);
		ResultSet rs=psd.executeQuery();
		while(rs.next()) {
			String allocationId=rs.getString(1);
			String patientId=rs.getString(2);
			String roomNumber=auObj.covertIntToString(rs.getInt(3));
			String noOfDays=auObj.covertIntToString(rs.getInt(4));
			String admissionDate=auObj.convertDateToString(rs.getDate(5));
			String dischargeDate=auObj.convertDateToString(rs.getDate(6));
			String treatment=rs.getString(7);
			String roomType=rs.getString(8);
			String wantFood=rs.getString(9);
			Allocation aObj=new Allocation(allocationId, patientId, roomNumber, noOfDays, admissionDate, dischargeDate, treatment, roomType, wantFood);
			aList.add(aObj);
		}
	} catch (ClassNotFoundException | SQLException | IOException e) {
		// TODO Auto-generated catch block
		System.err.println(e.getMessage());
	}
	
	return aList;
}

public int deleteFromDB(String id) {
	// TODO Auto-generated method stub
	int result=0;
	try {
		Connection con=DBConnectionManager.getConnection();
		PreparedStatement psd=con.prepareStatement("delete from allocation where PATIENT_ID=?");
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
	String allocationId="";
	try 
	{
		Connection con=DBConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement("select ALLOCATION_ID from allocation order by ALLOCATION_ID desc limit 1");
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			allocationId=rs.getString(1);
		}
		
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
	}
	return allocationId;
}	

}
