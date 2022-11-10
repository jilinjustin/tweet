package com.casestudy.tweet.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	static Connection con;

	public static Connection createC() {
		try {
			// to load driver
//			Class.forName("com.mysql.cj.jdbc.Driver");

			// create connection
			String user = "root";
			String password = "pass@word1";
			String url = "jdbc:mysql://localhost:3306/tweet";

			con = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

}
