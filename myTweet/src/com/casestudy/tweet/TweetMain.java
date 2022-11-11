package com.casestudy.tweet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.casestudy.tweet.dao.TweetDAO;
import com.casestudy.tweet.model.UserDetails;

public class TweetMain {

	public static void main(String[] args) {
		try {
			System.out.println("Welcome To Tweet");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			boolean flag = true;

			while (flag) {
				System.out.println("--- MENU ---");
				System.out.println("1. Register");
				System.out.println("2. Login");
				System.out.println("3. Forgot Password");
				System.out.println("4. exit");
				String choice = br.readLine();
				if (!choice.equals(null) && !choice.equals("")) {
					switch (choice) {
					case "1":
						userRegistration();
						break;
					case "2":
						userLogin();
						break;
					case "3":
						forgotPassword();
						break;
					case "4":
						System.out.println("Exiting");
						flag = false;
						break;
					default:
						System.out.println("Enter a Valid Option from the Menu");
						break;
					}
				} else {
					System.out.println("Enter a Valid Option");
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
			boolean result = false;
			if (!email.equals(null) && !email.equals("")) {
				result = TweetDAO.verifyUser(email);
			}

			if (result) {
				System.out.println("Email verified");
				System.out.println("Enter New Password: ");
				String password = br.readLine();
				boolean result1 = false;
				if (!password.equals(null) && !password.equals("")) {
					result1 = TweetDAO.setNewPwd(email, password);
				}

				if (result1) {
					System.out.println("New Password Updated");
				} else {
					System.out.println("Enter Valid Password");
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
			String pwd = null;
			if (!email.equals(null) && !email.equals("") && !password.equals(null) && !password.equals("")) {
				pwd = TweetDAO.getUserPassword(email);
			}

			if (pwd != null && pwd.equalsIgnoreCase(password)) {
				System.out.println("User Login successful");
				TweetDAO.updateStatus(email, "Logged In");
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

			String status = "Logged Out";

			UserDetails ud = new UserDetails(firstName, email, password, status);
			boolean result = false;
			if ((!firstName.equals(null) && !firstName.equals("")) && (!email.equals(null) && !email.equals(""))
					&& (!password.equals(null) && !password.equals(""))) {
				result = TweetDAO.registerUser(ud);
			}

			if (result) {
				System.out.println("User Registration successful");
			} else {
				System.out.println("Enter Valid Details for User Registration");
			}

		} catch (Exception e) {
			System.out.println("Exception in userRegistration() in TweetMain");
			e.printStackTrace();

		}
	}

}
