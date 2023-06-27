package com.javatraining.assignment6;

import java.io.File;
import java.io.IOException;
import java.util.*;



public class Main {
	static Scanner sc=new Scanner(System.in);
	static ProductCatalog productCatalog =new ProductCatalog();
	static ShoppingCart shoppingCart =new ShoppingCart();
	static OrderHistory orderHistory=new OrderHistory();
	static File f;
	static String filename;
	static int choice;

	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to RGTMessaging!");
		do {
			System.out.println("===== Online Shopping System =====");
			System.out.println("1. Create the product");
			System.out.println("2. Browse products");
			System.out.println("3. Add product to shopping cart");
			System.out.println("4. View shopping cart");
			System.out.println("5. Place order");
			System.out.println("6. View order history");
			System.out.println("7. Exit");
			System.out.println("Enter your choice: ");
			choice=sc.nextInt();
			switch (choice) {

			case 1:
				System.out.println("create a new product file \nEnter the file Name");
				filename= sc.next();
				createProducts(filename);
				break;

			case 2: 
				productCatalog.loadProduct();
				browseProducts();
				break;

			case 3: 
				addProductToCart();
				break;
			case 4:
				shoppingCart.displayItems();
				break;
			case 5:
				shoppingCart.placeOrder();
				break;
			case 6:
				viewOrderHistory();
				break;
			case 7:
				System.out.println("Thank you for using our Application, Visit again...");
				break;
			default:
				System.out.println("Invalid input...");
			}
		}while(!(choice==7));

	}

	private static void browseProducts() {
		System.out.println("===== Browse Products =====");
		Collection<Product> products = productCatalog.getAllProducts();
		if (products.isEmpty()) {
			System.out.println("No products available.");
		} else {
			for (Product product : products) {
				System.out.println("Name: "+product.getName()+"     Description: "+product.getDescription()+"     Price: "+product.getPrice()+"    Available Quantioty"+product.getQuantity());
			}
		}
	}
	private static void createProducts(String filename) {
		System.out.println("Enter product size");
		int size = sc.nextInt();
		for(int i=0;i<size;i++) {
			System.out.println("Enter product name");
			String productName = sc.next();
			productName+=sc.nextLine();
			System.out.println("Enter description name");
			String description = sc.nextLine();
			System.out.println("Enter price name");
			String price = sc.nextLine();
			System.out.println("Enter quantity name");
			String quantity = sc.nextLine();
			Product product =new Product(productName,description,price,quantity);
			productCatalog.addProducts(productName,product);
		}
		productCatalog.saveProducts(filename);
	}

	private static void addProductToCart(){
		System.out.println("===== Add Product to Shopping Cart =====");
		System.out.print("Enter the name of the product: ");
		String productName = sc.next();
		productName+=sc.nextLine();
		Product product = productCatalog.getProduct(productName);
		if (product == null) {
			System.out.println("Product not found.");
			return;
		}else {
		System.out.print("Enter the quantity: ");
		int quantity = sc.nextInt();
		if(quantity<=Integer.parseInt(product.getQuantity())){
			shoppingCart.addItem(product, quantity);
			System.out.println("Product added to the shopping cart.");
		}else {
			System.out.println("Entered Quantity is greater then the available quantity");
		}
		}
	}
	
	private static void viewOrderHistory(){
		System.out.println("===== Order History =====");
		orderHistory.loadOrderHistory();
		Collection<Order> orders = orderHistory.getAllOrders();
		if (orders.isEmpty()) {
			System.out.println("No products available.");
		} else {
			for (Order order : orders) {
				for(Map.Entry<Product, Integer> item:order.getItems().entrySet()) {
					System.out.println("ConformationNumber: "+order.getConfirmationNumber()+"\nName: "+item.getKey().getName()+"\nDescription: "+item.getKey().getDescription()
							+"\nPrice: "+order.getTotalPrice()+"\nQuantity: "+item.getValue());
				}
			}
		}
	}
	
}
