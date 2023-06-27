package com.javatraining.assignment6;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class ProductCatalog implements Serializable{

	Scanner sc=new Scanner(System.in);
	HashMap<String, Product> products;

	ProductCatalog(){
		products = new HashMap<>();
	}

	public void loadProduct(){
		System.out.println("Enter the file name");
		String fileName=sc.next();
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)))  {
			products = (HashMap<String, Product>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {

			System.out.println("Error loading products: " + e.getMessage());

		}


	}


	public void addProducts(String productName, Product productDetails) {
		products.put(productName, productDetails);
	}

	public void saveProducts(String fileName){
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName)))
		{
			oos.writeObject(products);
			System.out.println("Products Saved");
		}
		catch (IOException e){
			System.out.println("Error saving products: " + e.getMessage());
		}

	}

	public Product getProduct(String name) {
		return products.get(name);
	}

	public Collection<Product> getAllProducts() {
		return products.values();
	}
}
