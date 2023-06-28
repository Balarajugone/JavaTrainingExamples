package com.javatraining.assignment6;

import java.io.Serializable;
import java.util.HashMap;

public class Order implements Serializable{
	int confirmationNumber;
	HashMap<Product,Integer> items;
	double totalPrice;

	public Order(int confirmationNumber, HashMap<Product, Integer> items, double totalPrice) {
		this.confirmationNumber=confirmationNumber;
		this.items=items;
		this.totalPrice=totalPrice;
	}

	public int getConfirmationNumber() {
		return confirmationNumber;
	}

	public HashMap<Product, Integer> getItems() {
		return items;
	}

	public double getTotalPrice() {
		return totalPrice;
	}
}
