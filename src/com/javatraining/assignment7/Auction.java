package com.javatraining.assignment7;

import java.util.*;

//Auction class (Singleton)
/**
 * Singleton Design Pattern which creates only one instance for the class
 * 
 * @author BalarajuGone
 *
 */
public class Auction {
	private static Auction instance = null;
	private List<Item> items;

	private Auction() {
		items = new ArrayList<>();
	}

	/**
	 * 
	 * @return Return the instance of the class
	 */
	public static Auction getInstance() {
		if (instance == null) {
			instance = new Auction();
		}
		return instance;
	}

	/**
	 * Add items into the list
	 * 
	 * @param item
	 */
	public void addItem(Item item) {
		items.add(item);
	}

	/**
	 * 
	 * @return Return the items list
	 */
	public List<Item> getItem() {
		return items;
	}

}
