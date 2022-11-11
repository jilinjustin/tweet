package com.casestudy.tweet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.casestudy.tweet.connection.ConnectionProvider;
import com.casestudy.tweet.model.TweetDetails;
import com.casestudy.tweet.model.UserDetails;

public class TweetDAO {

	public static boolean registerUser(UserDetails ud) {
		boolean result = false;
		try {
			Connection con = ConnectionProvider.createC();
			String Query1 = "INSERT into userdetails(username,email,password) " + " VALUES (?,?,?)";

			PreparedStatement pstmt = con.prepareStatement(Query1);

			// setting values to parameters
			pstmt.setString(1, ud.getFirstName());
			pstmt.setString(2, ud.getEmail());
			pstmt.setString(3, ud.getPassword());

			pstmt.executeUpdate();
			result = true;

		} catch (Exception e) {
			System.out.println("Exception in registerUser in TweetDAO");
			e.printStackTrace();
		}
		return result;
	}

	public static String getUserPassword(String email) {
		String pwd = null;
		try {
			Connection con = ConnectionProvider.createC();
			String Query2 = "SELECT password from userdetails where email = ?";

			PreparedStatement ps = con.prepareStatement(Query2);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs != null && rs.next()) {
				pwd = rs.getString("password");
			}

		} catch (Exception e) {
			System.out.println("Exception in loginUser in TweetDAO");
			e.printStackTrace();
		}
		return pwd;
	}

	public static boolean verifyUser(String email) {
		boolean result = false;
		try {
			Connection con = ConnectionProvider.createC();
			String Query2 = "SELECT count(*) from userdetails where email = ?";

			PreparedStatement ps = con.prepareStatement(Query2);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs != null && rs.next()) {
				if (rs.getInt(1) == 1) {
					result = true;
				}
			}

		} catch (Exception e) {
			System.out.println("Exception in verifyUser in TweetDAO");
			e.printStackTrace();
		}
		return result;
	}

	public static boolean setNewPwd(String email, String password) {
		boolean result = false;
		try {
			Connection con = ConnectionProvider.createC();
			String Query3 = "UPDATE userdetails SET password = ? where email = ?";

			PreparedStatement ps = con.prepareStatement(Query3);
			ps.setString(1, password);
			ps.setString(2, email);

			ps.executeUpdate();
			result = true;

		} catch (Exception e) {
			System.out.println("Exception in setNewPwd in TweetDAO");
			e.printStackTrace();
		}
		return result;
	}

	public static boolean postTweet(TweetDetails td) {
		boolean result = false;
		try {
			Connection con = ConnectionProvider.createC();
			String Query4 = "INSERT into tweetdetails (email,content) VALUES (?,?);";

			PreparedStatement pstmt = con.prepareStatement(Query4);

			// setting values to parameters
			pstmt.setString(1, td.getEmail());
			pstmt.setString(2, td.getContent());

			pstmt.executeUpdate();
			result = true;

		} catch (Exception e) {
			System.out.println("Exception in postTweet in TweetDAO");
			e.printStackTrace();
		}
		return result;
	}

	public static boolean viewMyTweets(String email) {
		boolean status = false;
		try {
			Connection con = ConnectionProvider.createC();
			String Query5 = "SELECT * FROM tweetdetails where email = ? ";

			PreparedStatement ps = con.prepareStatement(Query5);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs != null && rs.next()) {
				String tweet = rs.getString("content");
				System.out.println(" --> " + tweet);
				status = true;
			}

		} catch (Exception e) {
			System.out.println("Exception in viewMyTweets() in TweetDAO");
			e.printStackTrace();
		}
		return status;
	}

	public static boolean viewAllTweets() {
		boolean status = false;
		try {
			Connection con = ConnectionProvider.createC();
			String Query6 = "SELECT * FROM tweetdetails";

			PreparedStatement ps = con.prepareStatement(Query6);
			ResultSet rs = ps.executeQuery();

			while (rs != null && rs.next()) {
				String tweet = rs.getString("content");
				String userName = rs.getString("email");
				System.out.println(" * " + userName + " --> " + tweet);
				status = true;
			}

		} catch (Exception e) {
			System.out.println("Exception in viewAllTweets() in TweetDAO");
			e.printStackTrace();
		}
		return status;
	}

	public static boolean viewAllUsers() {
		boolean status = false;
		try {
			Connection con = ConnectionProvider.createC();
			String Query7 = "SELECT * FROM userdetails";

			PreparedStatement ps = con.prepareStatement(Query7);
			ResultSet rs = ps.executeQuery();

			while (rs != null && rs.next()) {
				String userName = rs.getString("username");
				System.out.println(" --> " + userName);
				status = true;
			}

		} catch (Exception e) {
			System.out.println("Exception in viewAllUsers() in TweetDAO");
			e.printStackTrace();
		}
		return status;
	}

	public static void updateStatus(String email, String status) {		
		try {
			Connection con = ConnectionProvider.createC();
			String Query8 = "UPDATE userdetails SET status = ? where email = ?";

			PreparedStatement ps = con.prepareStatement(Query8);
			ps.setString(1, status);
			ps.setString(2, email);

			ps.executeUpdate();			

		} catch (Exception e) {
			System.out.println("Exception in updateStatus in TweetDAO");
			e.printStackTrace();
		}		
	}

}
