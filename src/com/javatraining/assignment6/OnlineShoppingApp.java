package com.javatraining.assignment6;

import java.util.*;

public class OnlineShoppingApp {
	static Scanner sc = new Scanner(System.in);
	static ProductCatalog productCatalog = new ProductCatalog();
	static ShoppingCart shoppingCart = new ShoppingCart();
	static OrderHistory orderHistory = new OrderHistory();
	static String filename;
	static int choice;

	public static void main(String[] args) throws Exception {
		do {
			try {
			System.out.println("===== Online Shopping System =====");
			System.out.println("1. Create the product");
			System.out.println("2. Browse products");
			System.out.println("3. Add product to shopping cart");
			System.out.println("4. View shopping cart");
			System.out.println("5. Place order");
			System.out.println("6. View order history");
			System.out.println("7. Exit");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			}catch (Exception e) {
				sc.next();
			}
			switch (choice) {

			case 1:
				createProducts();
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
		} while (!(choice == 7));

	}

	/**
	 * Browse the Existing Products
	 */
	private static void browseProducts() {
		System.out.println("===== Browse Products =====");
		Collection<Product> products = productCatalog.getAllProducts();
		if (products.isEmpty()) {
			System.out.println("No products available.");
		} else {
			for (Product product : products) {
//				System.out.println("Name: " + product.getName() + "     Description: " + product.getDescription()
//						+ "     Price: " + product.getPrice() + "    Available Quantioty" + product.getQuantity());
				System.out.println(product);
			}
		}
	}

	/**
	 * Create the new Products
	 */
	private static void createProducts() {
		System.out.println("Enter the file Name");
		filename = sc.next();
		System.out.println("Enter product size");
		int size = sc.nextInt();
		for (int i = 0; i < size; i++) {
			System.out.println("Enter product name");
			String productName = sc.next();
			productName += sc.nextLine();
			System.out.println("Enter description ");
			String description = sc.nextLine();
			System.out.println("Enter price ");
			String price = sc.nextLine();
			System.out.println("Enter quantity ");
			String quantity = sc.nextLine();
			Product product = new Product(productName, description, price, quantity);
			productCatalog.addProducts(productName, product);
		}
		productCatalog.saveProducts(filename);
	}

	/**
	 * Add products to cart
	 */
	private static void addProductToCart() {
		System.out.println("===== Add Product to Shopping Cart =====");
		System.out.print("Enter the name of the product: ");
		String productName = sc.next();
		productName += sc.nextLine();
		Product product = productCatalog.getProduct(productName);
		if (product == null) {
			System.out.println("Product not found.");
			return;
		} else {
			System.out.print("Enter the quantity: ");
			int quantity = sc.nextInt();
			if (quantity <= Integer.parseInt(product.getQuantity())) {
				shoppingCart.addItem(product, quantity);
				System.out.println("Product added to the shopping cart.");
			} else {
				System.out.println("Entered Quantity is greater then the available quantity");
			}
		}
	}

	/**
	 * View the order History
	 */
	private static void viewOrderHistory() {
		System.out.println("===== Order History =====");
		double TotalPrice = 0;
		orderHistory.loadOrderHistory();
		Collection<Order> orders = orderHistory.getAllOrders();
		if (orders.isEmpty()) {
			System.out.println("No products available.");
		} else {
			for (Order order : orders) {
				for (Map.Entry<Product, Integer> item : order.getItems().entrySet()) {
					TotalPrice += order.getTotalPrice();
					System.out.println("ConformationNumber: " + order.getConfirmationNumber() + "\nName: "
							+ item.getKey().getName() + "\nDescription: " + item.getKey().getDescription()
							+ "\nQuantity: " + item.getValue() + "\nPrice: " + order.getTotalPrice() + "\n");
				}
			}
			System.out.println("TotalPrice: " + TotalPrice);
		}
	}

}
