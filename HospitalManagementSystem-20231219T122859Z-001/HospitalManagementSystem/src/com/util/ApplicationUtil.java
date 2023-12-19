package com.util;
import java.sql.Time;
import java.text.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
public class ApplicationUtil {
	public List<String> extractDetails(String[] input){
		List<String> extracted=new ArrayList<String>();
		for(String i:input) {
			extracted.add(i);
		}
		return extracted;
	}

	public long convertLong(String phoneNumber) {
		// TODO Auto-generated method stub
		long phone=0;
		try {
			phone=Long.parseLong(phoneNumber);
		}catch(NumberFormatException e) {
			phone=0;
		}
		
		return phone;
	}

	public int convertInt(String age) {
		// TODO Auto-generated method stub
		int age1=Integer.parseInt(age);
		return age1;
	}

	
	public double convertDouble(String medicineFee) {
		// TODO Auto-generated method stub
		double medicinefee1=Double.parseDouble(medicineFee);
		return medicinefee1;
	}

	

	public String covertLongToString(long long1) {
		// TODO Auto-generated method stub
		return String.valueOf(long1);
	}

	public String covertIntToString(int int1) {
		// TODO Auto-generated method stub
		return String.valueOf(int1);
	}

	public String convertDoubleToString(double double1) {
		// TODO Auto-generated method stub
		return String.valueOf(double1);
	}

	public java.sql.Date dateConvert(String availableDate)   {
		// TODO Auto-generated method stub
//		java.sql.Date sqlDate=null;
	 try{
		 Date date =new SimpleDateFormat("yyyy-MM-dd",java.util.Locale.getDefault()).parse(availableDate);
		 return  new java.sql.Date(date.getTime());
	 }catch (ParseException e) {
		// TODO: handle exception
		 e.printStackTrace();
		 return null;
	}
	
		
	}

	public Time timeConvert(String availableTime) throws ParseException {
		// TODO Auto-generated method stub
		Time time=Time.valueOf(availableTime);
		return time;
	}

	public String convertDateToString(java.sql.Date date) {
		
		return date.toString();
		// TODO Auto-generated method stub
//		return null;
	}

	public String convertTimeToString(Time time) {
		// TODO Auto-generated method stub
		return time.toString();
	}

	
}
