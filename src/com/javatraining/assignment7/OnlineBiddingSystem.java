package com.javatraining.assignment7;

import java.util.List;
import java.util.Scanner;

public class OnlineBiddingSystem {
	static Scanner sc = new Scanner(System.in);
	static UserManagementService userManagementService = new UserManagementService();
	static ItemManagementService itemManagementService = new ItemManagementService();

	public static void main(String[] args) throws Exception {
		boolean option = true;

		do {
			int choice = 0;
			try {
				System.out.println("===== Online Bidding System =====");
				System.out.println("1. Create Account");
				System.out.println("2. Login");
				System.out.println("3. AddItems");
				System.out.println("4. Exit");
				System.out.println("Choose an option: ");

				choice = sc.nextInt();
			} catch (Exception e) {

				sc.next();
			}

			switch (choice) {

			case 1:
				userManagementService.createUser();
				break;
			case 2:
				User user = userManagementService.login();
				if (user != null) {
					mainMenue(user);
				} else {
					System.out.println("No user has been Registered, Please Register the user first");
				}
				break;
			case 3:
				itemManagementService.addItem();
				break;
			case 4:
				option = false;
				System.out.println("Exit");
				break;
			default:
				System.out.println("Invalid input, Please Enter the Valid Input");
			}

		} while (option);

	}

	public static void mainMenue(User user) {
		boolean option = true;
		while (option) {
			int choice = 0;
			try {
				System.out.println("===== Online Bidding System =====");
				System.out.println("1. Search Items");
				System.out.println("2. View Bidding History");
				System.out.println("3. Logout");
				System.out.println("Choose an option: ");
				choice = sc.nextInt();

				switch (choice) {

				case 1:
					System.out.println("Enter a search keyword");
					String keyword = sc.next();
					List<Item> items = itemManagementService.searchItems(keyword);
					for (Item item : items) {
						System.out.println(
								item.getName() + "  " + item.getDescription() + "  " + item.getCurrentHighestBid());
					}
					System.out.println("Enter an item name to place a bid, or '0' to go back:");
					String itemName;
					itemName = sc.next();
					itemName += sc.nextLine();
					for (Item item : items) {
						if (item.getName().equalsIgnoreCase(itemName)) {

							System.out.print("Enter the Bid Amount: ");
							double bidAmount = sc.nextDouble();
							Bid bid = new Bid(item.getName(), item.getDescription(), bidAmount);
							user.addBid(bid);
							int Choose = 0;

							System.out.println("\n1. Incremental Bidding");
							System.out.println("2. Automatic Bidding");
							System.out.println("Choose a bidding strategy: ");
							Choose = sc.nextInt();

							switch (Choose) {
							case 1:
								IncrementalBiddingStrategy incrementalBiddingStrategy = new IncrementalBiddingStrategy();
								System.out.println(incrementalBiddingStrategy.bid(item, user, bidAmount));

								break;
							case 2:
								AutomaticBiddingStrategy automaticBiddingStrategy = new AutomaticBiddingStrategy();
								System.out.println(automaticBiddingStrategy.bid(item, user, bidAmount));
								break;
							}
						}
					}
					break;
				case 2:
					for (Bid bidhist : user.getBiddingHistory())
						System.out.println(bidhist.getItemName() + " - " + bidhist.getDescription() + " - "
								+ bidhist.getBidAmount() + " - " + bidhist.isWinbid());
					break;
				case 3:
					option = false;
					break;
				default:
					System.out.println("Invalid input, Please Enter the Valid Input");
				}
			} catch (Exception e) {

				sc.next();
			}
		}
	}

}
