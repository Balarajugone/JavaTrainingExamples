package com.javatraining.assignment7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemManagementService {
	Scanner sc = new Scanner(System.in);
	private Auction auction;

	public ItemManagementService() {
		this.auction = Auction.getInstance();
	}

	/**
	 * Take itemName, Description and StartingBid amount as Parameters and add the
	 * item details into the list
	 * 
	 * @param name
	 * @param description
	 * @param startingBid
	 */
	public void addItem(String name, String description, double startingBid) {
		Item item = ItemFactory.createItem(name, description, startingBid);
		auction.addItem(item);
	}

	/**
	 * compares the list with the given keyword
	 * 
	 * @param keyword
	 * @return Return the item list if keyword matches
	 */
	public List<Item> searchItems(String keyword) {
		List<Item> items = new ArrayList<>();
		for (Item item : auction.getItem()) {
			if (item.getName().contains(keyword)) {
				items.add(item);
			}
		}
		return items;
	}

	/**
	 * Take user input and add the item
	 */
	public void addItem() {
		String itemname;
		System.out.println("Enter item Name");
		itemname = sc.next();
		itemname += sc.nextLine();
		System.out.println("Enter item Description");
		String description = sc.nextLine();
		System.out.println("Enter startingBid");
		double startingBid = sc.nextDouble();
		addItem(itemname, description, startingBid);
		System.out.println("item added sucessfully...");
	}
}
