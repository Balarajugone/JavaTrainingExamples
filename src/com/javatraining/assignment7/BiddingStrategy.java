package com.javatraining.assignment7;

//BiddingStrategy interface (Strategy)
public interface BiddingStrategy {
	public double bid(Item item, User user,double amount);
}
