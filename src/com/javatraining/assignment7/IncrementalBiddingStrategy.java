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
			return newBid;
		} else {
			System.out.println("Amount should not be less than the current bidding amount - "+currentBid);
			notificationService.notifyUser(user, item);
		}
		return 0;
		
	}

}
