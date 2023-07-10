package com.javatraining.assignment7;

import java.util.*;

public class UserManagementService {
	Scanner sc = new Scanner(System.in);
	private ArrayList<User> users;

	public UserManagementService() {
		this.users = new ArrayList<>();
	}

	/**
	 * Register the New User
	 */
	public void createUser() {
		String username;
		System.out.println("Enter your Name");
		username = sc.next();
		username += sc.nextLine();
		System.out.println("Enter your Password");
		String password = sc.nextLine();
		createUser(username, password);
	}

	/**
	 * Register the New User
	 * 
	 * @param username
	 * @param password
	 */
	public void createUser(String username, String password) {
		User user = new User(username, password);
		if (users.isEmpty() || !(userexist(username))) {
			users.add(user);
			System.out.println("Registered Sucessfully...");
		} else {
			System.out.println("UserName already Exist...");
		}
	}

	/**
	 * 
	 * @param username
	 * @return Return the user if exist
	 */
	public boolean userexist(String username) {
		Iterator<User> it = users.iterator();
		while (it.hasNext()) {
			if (it.next().getUsername().equalsIgnoreCase(username)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Askes for user input
	 * 
	 * @return Return the user
	 */
	public User login() {
		String username1;
		System.out.println("Enter your Name");
		username1 = sc.next();
		username1 += sc.nextLine();
		System.out.println("Enter your Password");
		String password1 = sc.nextLine();
		User user = authenticateUser(username1, password1);
		return user;
	}

	/**
	 * Takes the user name and password as parameters
	 * 
	 * @param username
	 * @param password
	 * @return Return the user if authentication get success
	 */
	public User authenticateUser(String username, String password) {
		if(users.isEmpty()) {
			System.out.println("The user is not Registered, Please Register the user first");
		}else {
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			} else {
				System.out.println("UserName or Password is incorrect...");
				break;
			}
		}
		}
		return null;

	}

}
