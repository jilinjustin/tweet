package com.learn.start.student;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

}
