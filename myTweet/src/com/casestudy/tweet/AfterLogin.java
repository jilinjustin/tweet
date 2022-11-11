package com.casestudy.tweet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.casestudy.tweet.dao.TweetDAO;
import com.casestudy.tweet.model.TweetDetails;
import com.casestudy.tweet.model.UserDetails;

public class AfterLogin {

	public static void displayMenu(UserDetails ud) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Welcome " + ud.getEmail());
			boolean flag = true;

			while (flag) {
				System.out.println("1. Post a Tweet");
				System.out.println("2. View my Tweets");
				System.out.println("3. View all Tweets");
				System.out.println("4. View all Users");
				System.out.println("5. Reset Password");
				System.out.println("6. Logout");
				int choice = Integer.parseInt(br.readLine());

				switch (choice) {
				case 1:
					postTweet(ud);
					break;
				case 2:
					viewMyTweets(ud);
					break;
				case 3:
					viewAllTweets();
					break;
				case 4:
					viewAllUsers();
					break;
				case 5:
					resetPassword(ud);
					break;
				case 6:
					System.out.println("Logging out");
					TweetDAO.updateStatus(ud.getEmail(), "Logged Out");
					flag = false;
					break;
				default:
					System.out.println("Wrong Option");
					break;
				}

			}

		} catch (Exception e) {
			System.out.println("Exception in displayMenu in AfterLogin");
			e.printStackTrace();
		}

	}

	private static void resetPassword(UserDetails ud) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter Old Password: ");
			String oldPassword = br.readLine();

			String pwd = TweetDAO.getUserPassword(ud.getEmail());

			if (pwd != null && pwd.equalsIgnoreCase(oldPassword)) {
				System.out.println("Enter New Password: ");
				String newPassword = br.readLine();
				boolean result1 = TweetDAO.setNewPwd(ud.getEmail(), newPassword);

				if (result1) {
					System.out.println("New Password Updated");
				} else {
					System.out.println("Error Occured while updating new Password");
				}
			} else {
				System.out.println("Incorrect Password");
			}

		} catch (Exception e) {
			System.out.println("Exception in resetPassword() in AfterLogin");
			e.printStackTrace();
		}

	}

	private static void viewAllUsers() {
		try {
			System.out.println("All Users");

			boolean result = TweetDAO.viewAllUsers();

			if (result) {
				System.out.println("All Users Shown");
			} else {
				System.out.println("Error Occured while retrieving User Details");
			}

		} catch (Exception e) {
			System.out.println("Exception in viewAllUsers() in AfterLogin");
			e.printStackTrace();
		}

	}

	private static void viewAllTweets() {
		try {
			System.out.println("All Tweets");

			boolean result = TweetDAO.viewAllTweets();

			if (result) {
				System.out.println("All Tweets Shown");
			} else {
				System.out.println("No Tweets to View");
			}

		} catch (Exception e) {
			System.out.println("Exception in viewAllTweets() in AfterLogin");
			e.printStackTrace();
		}

	}

	private static void viewMyTweets(UserDetails ud) {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Your Tweets");

			boolean result = TweetDAO.viewMyTweets(ud.getEmail());

			if (result) {
				System.out.println("All Tweets Shown");
			} else {
				System.out.println("No Tweets to View");
			}

		} catch (Exception e) {
			System.out.println("Exception in viewMyTweets() in AfterLogin");
			e.printStackTrace();
		}

	}

	private static void postTweet(UserDetails ud) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter your Tweet");

			String content = br.readLine();

			TweetDetails td = new TweetDetails(ud.getEmail(), content);
			boolean result = TweetDAO.postTweet(td);

			if (result) {
				System.out.println("Tweet posted successfully");
			} else {
				System.out.println("Error Occured in post creation");
			}

		} catch (Exception e) {
			System.out.println("Exception in postTweet() in AfterLogin");
			e.printStackTrace();
		}

	}

}
