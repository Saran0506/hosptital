package com.management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.InPatient;
import com.util.ApplicationUtil;

public class InPatientManagement {
	ApplicationUtil auObj=new ApplicationUtil();
	public List<InPatient> insertIntoDb(List<InPatient> buildList) {
		// TODO Auto-generated method stub
		List<InPatient> ipList=new ArrayList<InPatient>();
		try {
			
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement psd=con.prepareStatement("insert into inpatient values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			for(InPatient i:buildList) {
				psd.setString(1,i.getPatientId());
				psd.setString(2, i.getPatientName());
				psd.setLong(3, auObj.convertLong(i.getPhoneNumber()));
				psd.setInt(4, auObj.convertInt(i.getAge()));
				psd.setString(5, i.getGender());
				psd.setString(6, i.getMedicalHistory());
				psd.setString(7,i.getPrefferedSpecialist());
				psd.setDouble(8, auObj.convertDouble(i.getMedicineFee()));
				psd.setString(9, i.getPatientType());
				psd.setDouble(10,auObj.convertDouble(i.getAdmissionFees()) );
				psd.setString(11, i.getTreatment());
				psd.setString(12, i.getRoomType());
				psd.setString(13, i.getWantFood());
				psd.execute();
				ipList.add(i);
			}
		} catch (ClassNotFoundException  |IOException | SQLException  e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} 
		return ipList;
	}
	public int updateDb(String id, long phoneNumber) {
		int result=0;
		try {
			Connection con =DBConnectionManager.getConnection();
			PreparedStatement psd=con.prepareStatement("update inpatient set PHONE_NUMBER=? WHERE PATIENT_ID=?");
			psd.setLong(1, phoneNumber);
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
	public List<InPatient> retriveFromDb(String input){
		 try {
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement psd=con.prepareStatement("Select * from inpatient where PATIENT_ID=?");
			psd.setString(1, input);
			ResultSet rs=psd.executeQuery();
			List<InPatient> iPatientList=new ArrayList<InPatient>();
//			 oPatient=null;
					while(rs.next()) {
						InPatient iPatient=new InPatient();
						iPatient.setPatientId(rs.getString(1));
						iPatient.setPatientName(rs.getString(2));
						iPatient.setPhoneNumber(auObj.covertLongToString(rs.getLong(3)));
						iPatient.setAge(auObj.covertIntToString(rs.getInt(4)));
						iPatient.setGender(rs.getString(5));
						iPatient.setMedicalHistory(rs.getString(6));
						iPatient.setPrefferedSpecialist(rs.getString(7));
						iPatient.setMedicineFee(auObj.convertDoubleToString(rs.getDouble(8)));
						iPatient.setPatientType(rs.getString(9));
						iPatient.setAdmissionFees(auObj.convertDoubleToString(rs.getDouble(10)));
						iPatient.setTreatment(rs.getString(11));
						iPatient.setRoomType(rs.getString(12));
						iPatient.setWantFood(rs.getString(13));
						iPatientList.add(iPatient);
					}
					return iPatientList;
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch bloc
			System.err.println(e.getMessage());
		}
		return null; 
	}
	public int deleteFromDb(String id1) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement psd=con.prepareStatement("delete from inpatient WHERE PATIENT_ID=?");
			psd.setString(1, id1);
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
	public int updateRoomFromDB(String id, String roomType) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement psd=con.prepareStatement("update inpatient set ROOM_TYPE=? WHERE PATIENT_ID=?");
			psd.setString(1, roomType);
			psd.setString(2, id);
			result=psd.executeUpdate();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		return result;
	}
	public int updateFoodFromDB(String id, String food) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement psd=con.prepareStatement("update inpatient set WANT_FOOD=? WHERE PATIENT_ID=?");
			psd.setString(1, food);
			psd.setString(2, id);
			result=psd.executeUpdate();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		return result;
	}
	public  String checkIdExist() 
	{
		String patientId="";
		try 
		{
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement("select PATIENT_ID from inpatient order by PATIENT_ID desc limit 1");
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				patientId=rs.getString(1);
			}
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		return patientId;
	}
}
