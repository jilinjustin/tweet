package com.learn.start.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
	
	public static boolean addStudent(Student st) {
		boolean status = false;
		try {
			Connection con = ConnectionProvider.createC();
			String Query1 = "INSERT into student(sname,sphone,scity) values (?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(Query1);
			
			//setting values to parameters
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			pstmt.executeUpdate();
			status = true;
			
		} catch(Exception e) {
			
		}
		return status;
	}
	
	public static boolean deleteStudent(Integer sid) {
		boolean status = false;
		try {
			Connection con = ConnectionProvider.createC();
			String Query1 = "DELETE FROM student where sid =?";
			
			PreparedStatement pstmt = con.prepareStatement(Query1);
			
			//setting values to parameters
			pstmt.setInt(1,sid);			
			
			pstmt.executeUpdate();
			status = true;
			
		} catch(Exception e) {
			
		}
		return status;
	}
	
	public static boolean getAllStudent() {
		boolean status = false;
		try {
			Connection con = ConnectionProvider.createC();
			String Query1 = "SELECT * FROM student ";
			
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(Query1);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);
				
				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("PhoneNumber: " + phone);
				System.out.println("City: " + city);
				System.out.println("-----------------------------------------------------------------");
			}
			
			status = true;
			
		} catch(Exception e) {
			
		}
		return status;
	}

}
