package com.javatraining.assignment7;

public class Bid {
	private String itemName;
	private String description;
	private double bidAmount;
	private boolean winbid;

	/**
	 * Constructor for the Bid class
	 * 
	 * @param itemName
	 * @param description
	 * @param bidAmount
	 */
	public Bid(String itemName, String description, double bidAmount) {
		this.itemName = itemName;
		this.description = description;
		this.bidAmount = bidAmount;
	}

	/**
	 * 
	 * @return Return the Item Name
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * 
	 * @return Return the Item Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @return Return the bid amount
	 */
	public double getBidAmount() {
		return bidAmount;
	}

	/**
	 * Set the Winning bidder
	 */
	public void setWinbid() {
		this.winbid = winbid;
	}

	/**
	 * 
	 * @return Return the Winning bidder
	 */
	public boolean isWinbid() {
		return winbid;
	}

}
