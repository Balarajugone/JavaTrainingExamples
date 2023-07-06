package com.javatraining.assignment7;

public class Item {
	private String name;
	private String description;
	private double currentHighestBid;
	private User highestBidder;

	/**
	 * Constructor for Item class
	 * 
	 * @param name
	 * @param description
	 * @param startingBid
	 */
	public Item(String name, String description, double startingBid) {
		this.name = name;
		this.description = description;
		this.currentHighestBid = startingBid;
	}

	/**
	 * 
	 * @return Return the Item Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return Return the Item Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Add the bidding price and bidding user
	 * 
	 * @param user
	 * @param bidAmount
	 */
	public void placeBid(User user, double bidAmount) {
		if (bidAmount > currentHighestBid) {
			currentHighestBid = bidAmount;
			highestBidder = user;
		}
	}

	/**
	 * 
	 * @return Return the Current bidding price
	 */
	public double getCurrentHighestBid() {
		return currentHighestBid;
	}

	/**
	 * 
	 * @return Return the Highest bidding User
	 */
	public User getHighestBidder() {
		return highestBidder;
	}
}
