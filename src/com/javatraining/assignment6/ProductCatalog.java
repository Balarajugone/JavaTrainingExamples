package com.javatraining.assignment6;

import java.util.*;
import java.io.*;

public class ProductCatalog implements Serializable {

	Scanner sc = new Scanner(System.in);
	HashMap<String, Product> products;

	ProductCatalog() {
		products = new HashMap<>();
	}

	/**
	 * DeSeralize the Products
	 */
	public void loadProduct() {
		System.out.println("Enter the file name");
		String fileName = sc.next();
		File f = new File(
				"C:\\Balaraju\\Java\\Training_Workspace\\JavaTrainingExamples\\src\\com\\javatraining\\assignment6\\"
						+ fileName);
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
			products = (HashMap<String, Product>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {

			System.out.println("Error loading products: " + e.getMessage());

		}

	}

	/**
	 * Add the products to the products HashMap
	 * 
	 * @param productName
	 * @param productDetails
	 */
	public void addProducts(String productName, Product productDetails) {
		products.put(productName, productDetails);
	}

	/**
	 * Seralize the products
	 * 
	 * @param fileName
	 */
	public void saveProducts(String fileName) {
		File f = new File(
				"C:\\Balaraju\\Java\\Training_Workspace\\JavaTrainingExamples\\src\\com\\javatraining\\assignment6\\"
						+ fileName);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
			oos.writeObject(products);
			System.out.println("Products Saved");
		} catch (IOException e) {
			System.out.println("Error saving products: " + e.getMessage());
		}

	}

	/**
	 * Return the product
	 * 
	 * @param name
	 * @return
	 */
	public Product getProduct(String name) {
		return products.get(name);
	}

	/**
	 * Return the Product values
	 * 
	 * @return
	 */
	public Collection<Product> getAllProducts() {
		return products.values();
	}
}
