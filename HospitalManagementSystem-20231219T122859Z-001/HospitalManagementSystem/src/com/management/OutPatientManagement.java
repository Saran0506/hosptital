package com.management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.*;
import com.util.ApplicationUtil;

public class OutPatientManagement {
	ApplicationUtil auObj=new ApplicationUtil();
	public List<OutPatient> insertIntoDb(List<OutPatient> input){
		List<OutPatient> outpatient=new ArrayList<OutPatient>();
		
			
//			String url="jdbc:mysql://localhost:3306/hospital_management_system";
//			String username="root";
//			String password="";
//			Connection con = DriverManager.getConnection(url, username, password);
			Connection con;
			try {
				con = DBConnectionManager.getConnection();
				PreparedStatement psd=con.prepareStatement("insert into outpatient values (?,?,?,?,?,?,?,?,?,?)");
				for(OutPatient op:input) {
					
						psd.setString(1, op.getPatientId());
						psd.setString(2, op.getPatientName());
						psd.setLong(3, auObj.convertLong(op.getPhoneNumber()));
						psd.setInt(4, auObj.convertInt(op.getAge()));
						psd.setString(5, op.getGender());
						psd.setString(6, op.getMedicalHistory());
						psd.setString(7, op.getPrefferedSpecialist());
						psd.setDouble(8, auObj.convertDouble(op.getMedicineFee()));
						psd.setString(9, op.getPatientType());
						psd.setDouble(10, auObj.convertDouble(op.getRegistrationFees()));
						
						psd.execute();
						outpatient.add(op);	}
				
			} catch (ClassNotFoundException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
		
		return outpatient;
	}

	public int updateToDb(String id, long phoneNumber) {
		// TODO Auto-generated method stub
		Connection con;
		int result=0;
		try {
			con = DBConnectionManager.getConnection();
			PreparedStatement psd=con.prepareStatement("update outpatient set PHONE_NUMBER=? WHERE PATIENT_ID=?");
			psd.setLong(1, phoneNumber);
			psd.setString(2, id);
			 result=psd.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return result;
	}
	public List<OutPatient> retriveFromDb(String input){
		 try {
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement psd=con.prepareStatement("Select * from outpatient where PATIENT_ID=?");
			psd.setString(1, input);
			ResultSet rs=psd.executeQuery();
			List<OutPatient> oPatientList=new ArrayList<OutPatient>();
//			 oPatient=null;
					while(rs.next()) {
						OutPatient oPatient=new OutPatient();
						oPatient.setPatientId(rs.getString(1));
						oPatient.setPatientName(rs.getString(2));
						oPatient.setPhoneNumber(auObj.covertLongToString(rs.getLong(3)));
						oPatient.setAge(auObj.covertIntToString(rs.getInt(4)));
						oPatient.setGender(rs.getString(5));
						oPatient.setMedicalHistory(rs.getString(6));
						oPatient.setPrefferedSpecialist(rs.getString(7));
						oPatient.setMedicineFee(auObj.convertDoubleToString(rs.getDouble(8)));
						oPatient.setPatientType(rs.getString(9));
						oPatient.setRegistrationFees(auObj.convertDoubleToString(rs.getDouble(10)));
						oPatientList.add(oPatient);
					}
					return oPatientList;
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch bloc
			System.err.println(e.getMessage());
		}
		return null; 
	}

	public int deleteFromDb(String id) {
		int result=0;
		Connection con;
		try {
			con = DBConnectionManager.getConnection();
			PreparedStatement psd=con.prepareStatement("delete from outpatient where PATIENT_ID=?");
			psd.setString(1, id);
			 result=psd.executeUpdate();
//			return result;
			// TODO Auto-generated method stub
			
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
			PreparedStatement ps = con.prepareStatement("select PATIENT_ID from outpatient order by PATIENT_ID desc limit 1");
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
