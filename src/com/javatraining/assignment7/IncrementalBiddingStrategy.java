package com.javatraining.assignment7;

public class IncrementalBiddingStrategy implements BiddingStrategy {
	/**
	 * Return the new bid amount if given bid amount is greater than the current bid
	 * amount
	 */
	@Override
	public double bid(Item item, User user, double newBid) {
		NotificationService notificationService = new NotificationService();
		double currentBid = item.getCurrentHighestBid();
		if (newBid > currentBid) {
			item.placeBid(user, newBid);
		} else {
			System.out.println("Amount should not be less than the minimum bidding amount...");
			notificationService.notifyUser(user, item);
		}
		return newBid;
	}

}
