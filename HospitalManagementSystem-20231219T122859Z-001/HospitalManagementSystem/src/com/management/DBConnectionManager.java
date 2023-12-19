package com.management;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class DBConnectionManager  {
	
	public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException{
		
		FileInputStream fis=new FileInputStream("database.properties");
		Properties prop=new Properties();
		prop.load(fis);
//		String driverName=(String)prop.getProperty("drivername");
//		Class.forName(driverName);
		String url=(String)prop.getProperty("url");
		String username=(String)prop.getProperty("username");
		String password=(String)prop.getProperty("password");
		Connection con=DriverManager.getConnection(url,username,password);
//		System.out.println("----Apollo Hospital Management----");
		return con;
	}
	
	
	
	
}