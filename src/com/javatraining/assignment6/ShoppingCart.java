package com.javatraining.assignment6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ShoppingCart {
	Scanner sc = new Scanner(System.in);
	HashMap<Product, Integer> items;
	Order order;
	OrderHistory orderHistory = new OrderHistory();
	int conformationNum = getConformationNum();

	public ShoppingCart() {
		items = new HashMap<>();
	}

	/**
	 * Add Products and quantity to the Map variable items as key value pair
	 * 
	 * @param product
	 * @param quantity
	 */
	public void addItem(Product product, int quantity) {
		items.put(product, quantity);
	}

	/**
	 * Remove the product from the Map
	 * 
	 * @param product
	 */
	public void removeItem(Product product) {
		items.remove(product);
	}

	/**
	 * Returns the total price of the Shopping cart products
	 * @return
	 */
	public double getTotalPrice() {
		double totalPrice = 0;
		for (Map.Entry<Product, Integer> item : items.entrySet()) {
			totalPrice += Integer.parseInt(item.getKey().getPrice()) * item.getValue();
		}
		return totalPrice;
	}

	/**
	 * Place the order
	 */
	public void placeOrder() {
		for (HashMap.Entry<Product, Integer> item : items.entrySet()) {
			HashMap<Product, Integer> prd = new HashMap<>();
			prd.put(item.getKey(), item.getValue());
			int price = Integer.parseInt(item.getKey().getPrice()) * item.getValue();
			order = new Order(conformationNum, prd, price);
			orderHistory.addOrder(order);
		}
		System.out.println("Order Placed Sucessfully...");
		clear();
	}

	/**
	 * Display the available products from the shopping cart
	 */
	public void displayItems() {
		if (items.isEmpty()) {
			System.out.println("Shopping cart is empty.");
			return;
		}
		System.out.println("Items in the shopping cart:");
		for (Map.Entry<Product, Integer> item : items.entrySet()) {
			int price = Integer.parseInt(item.getKey().getPrice()) * item.getValue();
			System.out.println(item.getKey().getName() + " - Quantity: " + item.getValue() + "  - Price: " + price);
		}
		System.out.println("Total Price:  " + getTotalPrice());
		System.out.println("Do you want to remove the Product (Y/N)");
		String remove = sc.next();
		if (remove.equalsIgnoreCase("y")) {
			System.out.println("Enter the product you want to Remove");
			String removeProduct = sc.next();
			removeProduct += sc.nextLine();
			for (Map.Entry<Product, Integer> item : items.entrySet()) {
				if (item.getKey().getName().equalsIgnoreCase(removeProduct)) {
					removeItem(item.getKey());
					System.out.println("Product removed Sucessfully");
					break;
				}
			}
		}
	}

	public int getConformationNum() {
		Random rm = new Random();
		return rm.nextInt(100000000);
	}

	public void clear() {
		items.clear();
	}
	/*
	 * //Place order for the given product public void placeOrder() {
	 * if(items.size()>1) {
	 * System.out.println("Enter the item you want to Place an order."); String
	 * product=sc.next(); product+=sc.nextLine(); for (HashMap.Entry < Product,
	 * Integer > item: items.entrySet()){
	 * if(item.getKey().getName().equalsIgnoreCase(product)) { HashMap< Product,
	 * Integer > prd= new HashMap<>(); prd.put(item.getKey(), item.getValue());
	 * order = new Order(conformationNum,prd,getTotalPrice());
	 * orderHistory.addOrder(order);
	 * System.out.println("Order Placed Sucessfully..."); removeItem(item.getKey());
	 * break; } }
	 * 
	 * }else { order = new Order(conformationNum,items,getTotalPrice());
	 * orderHistory.addOrder(order);
	 * System.out.println("Order Placed Sucessfully..."); clear(); }
	 * 
	 * }
	 */
}
