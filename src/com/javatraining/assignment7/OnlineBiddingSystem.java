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
					System.out.println("Welcome Mr/Mrs " + user.getUsername());
					mainMenue(user);
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
							// Bid bid = new Bid(item.getName(), item.getDescription(), bidAmount);
							int Choose = 0;

							System.out.println(
									"1. Incremental Bidding \n 2. Automatic Bidding \n Choose a bidding strategy: ");
							Choose = sc.nextInt();
							double bids;
							Bid bid;
							BiddingStrategy biddingStrategy;
							switch (Choose) {
							case 1:
								biddingStrategy = new IncrementalBiddingStrategy();
								bids = biddingStrategy.bid(item, user, bidAmount);
								if (bids != 0) {
									bid = new Bid(item.getName(), item.getDescription(), bidAmount);
									user.addBid(bid);
								}
								System.out.println(bidAmount);
								break;
							case 2:
								biddingStrategy = new AutomaticBiddingStrategy();
								bids = biddingStrategy.bid(item, user, bidAmount);
								bidAmount = bids;
								bid = new Bid(item.getName(), item.getDescription(), bidAmount);
								user.addBid(bid);
								System.out.println(bids);
								break;
							}
						}
					}
					break;
				case 2:
					if (user.getBiddingHistory().isEmpty()) {
						System.out.println("There are No successfull bids yet...");
					} else {
						for (Bid bidhist : user.getBiddingHistory())
							System.out.println(bidhist.getItemName() + " - " + bidhist.getDescription() + " - "
									+ bidhist.getBidAmount() + " - " + bidhist.isWinbid());
					}
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
