package com.casestudy.tweet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.casestudy.tweet.dao.TweetDAO;
import com.casestudy.tweet.model.UserDetails;

public class TweetMain {

	public static void main(String[] args) {
		try {
			System.out.println("Welcome To ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			boolean flag = true;

			while (flag) {

				System.out.println("1. Register");
				System.out.println("2. Login");
				System.out.println("3. Forgot Password");
				System.out.println("4. exit");
				int choice = Integer.parseInt(br.readLine());

				switch (choice) {
				case 1:
					userRegistration();
					break;
				case 2:
					userLogin();
					break;
				case 3:
					forgotPassword();
					break;
				case 4:
					System.out.println("Exiting");
					flag = false;
					break;
				default:
					System.out.println("Wrong Option");
					break;
				}

			}

		} catch (Exception e) {
			System.out.println("Exception in main() in TweetMain");
			e.printStackTrace();
		}
	}

	private static void forgotPassword() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter Email to set New Password");

			System.out.println("Email: ");
			String email = br.readLine();

			boolean result = TweetDAO.verifyUser(email);

			if (result) {
				System.out.println("Email verified");
				System.out.println("Enter New Password: ");
				String password = br.readLine();
				boolean result1 = TweetDAO.setNewPwd(email, password);

				if (result1) {
					System.out.println("New Password Updated");
				} else {
					System.out.println("Error Occured while updating new Password");
				}

			} else {
				System.out.println("Invalid Email Address");
			}

		} catch (Exception e) {
			System.out.println("Exception in forgotPassword() in TweetMain");
			e.printStackTrace();
		}

	}

	private static void userLogin() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter Details to Login");

			System.out.println("Email: ");
			String email = br.readLine();

			System.out.println("Password: ");
			String password = br.readLine();

			UserDetails ud = new UserDetails(email, password);
			String pwd = TweetDAO.getUserPassword(email);

			if (pwd != null && pwd.equalsIgnoreCase(password)) {
				System.out.println("User Login successful");
				TweetDAO.updateStatus(email,"Logged In");
				AfterLogin.displayMenu(ud);
			} else {
				System.out.println("Incorrect Username/Password");
			}

		} catch (Exception e) {
			System.out.println("Exception in userLogin() in TweetMain");
			e.printStackTrace();

		}

	}

	private static void userRegistration() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter Details to Register User");
			System.out.println("First name: ");
			String firstName = br.readLine();

			System.out.println("Email: ");
			String email = br.readLine();

			System.out.println("Password: ");
			String password = br.readLine();

			UserDetails ud = new UserDetails(firstName, email, password);
			boolean result = TweetDAO.registerUser(ud);

			if (result) {
				System.out.println("User Registration successful");
			} else {
				System.out.println("Error Occured during user registration");
			}

		} catch (Exception e) {
			System.out.println("Exception in userRegistration() in TweetMain");
			e.printStackTrace();

		}
	}

}
