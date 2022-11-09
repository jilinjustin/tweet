package com.learn.start.student;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	Connection con;
	
	public void createC() {
		try {
			//to load driver
			Class.forName("com.sql.jdbc.driver");
			
			//create connection
			String user = "";
			String password = "";
			String url = "http://localhost:3306/studentmanagement";
			
			con = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
