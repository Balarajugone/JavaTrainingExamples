package com.javatraining.assignment7;

import java.util.Date;

public class AutomaticBiddingStrategy implements BiddingStrategy {

	@Override
	/**
	 * Return the new bid amount by incrementing the current bid amount by one
	 */
	public double bid(Item item, User user, double amount) {
		double currentBid = item.getCurrentHighestBid();
		double newBid = currentBid + 1.0;
		item.placeBid(user, newBid);
		return newBid;
	}
}
