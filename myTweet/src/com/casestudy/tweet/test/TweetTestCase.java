package com.casestudy.tweet.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.casestudy.tweet.TweetMain;
import com.casestudy.tweet.connection.ConnectionProvider;
import com.casestudy.tweet.dao.TweetDAO;
import com.casestudy.tweet.model.UserDetails;

//import com.learn.junitdemo.Calculator;

class TweetTestCase {
	
	static Connection con;

	@Test
	@DisplayName("Test User Registration")
	public void testUserRegistration() {
		TweetDAO td = new TweetDAO();
		try {			
			Connection con = ConnectionProvider.createC();
			con.setAutoCommit(false);
//			String Query1 = "INSERT into userdetails(username,email,password) " + " VALUES (?,?,?)";

			Statement pstmt = con.createStatement();
			pstmt.executeUpdate("DELETE FROM userdetails");
			
			String userName = "Jilin";
			String email = "jilin@abc.com";
			String password = "team";
			String status = "Logged Out";
			
			UserDetails ud = new UserDetails(userName, email, password,status);
			boolean answer = td.registerUser(ud);

			assertEquals("true", answer);
			
			try(ResultSet rs = pstmt.executeQuery("SELECT * FROM userdetails")) {
				assertTrue(rs.next());
				assertEquals("Jilin", rs.getString("username"));
				assertEquals("jilin@abc.com", rs.getString("email"));
				assertEquals("team", rs.getString("password"));
				assertEquals("Logged Out", rs.getString("status"));				
			}

			finally {
				con.rollback();
			}
			
			
		} catch(Exception e) {
			System.out.println("Exception in testUserRegistration() in TweetTestCase ");
			e.printStackTrace();
		}		

	}
	
//	void test() {
//		fail("Not yet implemented");
//	}

}
