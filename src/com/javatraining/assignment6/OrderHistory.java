package com.javatraining.assignment6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderHistory implements Serializable {
	List<Order> orders = new ArrayList<>();
	File fileName;
	int confirmationNumber;

	/**
	 * Deseralize the order History
	 */
	public void loadOrderHistory() {
		fileName = new File(
				"C:\\Balaraju\\Java\\Training_Workspace\\JavaTrainingExamples\\src\\com\\javatraining\\assignment6\\OrderHistory");
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(fileName));
			orders = (List<Order>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error loading order history: " + e.getMessage());
		}

	}

	/**
	 * Seralize the order History
	 */
	public void saveOrderHistory() {
		fileName = new File(
				"C:\\Balaraju\\Java\\Training_Workspace\\JavaTrainingExamples\\src\\com\\javatraining\\assignment6\\OrderHistory");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			oos.writeObject(orders);
		} catch (IOException e) {
			System.out.println("Error saving order history: " + e.getMessage());
		}
	}

	/**
	 * Add orders to the list
	 * 
	 * @param order
	 */
	public void addOrder(Order order) {
		orders.add(order);
		saveOrderHistory();
	}

	/**
	 * Returns the available Orders
	 * @return
	 */
	public List<Order> getAllOrders() {
		return orders;
	}

}
