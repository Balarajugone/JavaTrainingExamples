package com.javatraining.assignment7;

import java.util.*;

public class User {
	private String username;
	private String password;
	private List<Bid> biddingHistory;

	/**
	 * Constructor for User class
	 * 
	 * @param username
	 * @param password
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.biddingHistory = new ArrayList<>();
	}

	/**
	 * 
	 * @return Return the UserName
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @return Return the Password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @return Return the bidding history as list
	 */
	public List<Bid> getBiddingHistory() {
		return biddingHistory;
	}

	/**
	 * Add the bid details to the list
	 * 
	 * @param bid
	 * 
	 */
	public void addBid(Bid bid) {
		biddingHistory.add(bid);
	}
}
