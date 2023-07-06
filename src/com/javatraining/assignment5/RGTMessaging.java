package com.javatraining.assignment5;

import java.util.*;

public class RGTMessaging {
	Scanner sc = new Scanner(System.in);
	String currentuser;
	DataStore datastore;

	RGTMessaging() {
		datastore = new DataStore();
	}

	/**
	 * Register the new user
	 */
	public void registerUser() {
		System.out.println("\nEnter UserName: ");
		String userName = sc.next();
		System.out.println("\nEnter Password: ");
		String password = sc.next();
		System.out.println("\nEnter Name: ");
		String name = sc.nextLine();
		name += sc.nextLine();
		System.out.println("\nEnter bio: ");
		String bio = sc.nextLine();
		if (datastore.isUserExists(userName)) {
			System.out.println("Username already exists. Please choose a different username.");
		} else {
			User User = new User(userName, password, name, bio);
			datastore.addUser(User);
			System.out.println("User registered successfully!!");
		}
	}

	/**
	 * Login the User
	 */
	public void login() {
		System.out.println("\nEnter UserName: ");
		String uName = sc.next();
		System.out.println("\nEnter Password: ");
		String password = sc.next();
		User User = datastore.getUser(uName);
		if (User != null && User.getPassword().equals(password)) {
			currentuser = User.getuserName();
			userMenu(User.getName());
		} else {
			System.out.println("\nUserName or Password invalid, Please try again ");
		}
	}

	public boolean logout() {
		return true;
	}

	/**
	 * Search for the User and Display the User Details
	 */
	public void searchUser() {
		System.out.println("Enter UserName: ");
		String uName = sc.next();
		User User = datastore.getUser(uName);
		if (User == null) {
			System.out.println("UserName doesn't Exist...");
		} else {
			System.out.println("UserName:  " + User.getuserName());
			System.out.println("Name:      " + User.getName());
			System.out.println("bio:       " + User.getbio());
			System.out.println("Followers: " + User.getfollowersCount());
			System.out.println("Following: " + User.getfollowingsCount());
			System.out.println("Tweets:    " + User.gettweetsCount());
			if (!User.isfollow(datastore.getUser(currentuser))) {
				System.out.println("To follow click 1 \nTo skip click 2 \nchoose your option");
				int follow = sc.nextInt();
				switch (follow) {
				case 1:
					User.follow(datastore.getUser(currentuser));
					break;
				case 2:
					break;
				}
			} else {
				System.out.println("To unfollow click 1 \nTo skip click 2 \nchoose your option");
				int unfollow = sc.nextInt();
				switch (unfollow) {
				case 1:
					User.unfollow(datastore.getUser(currentuser));
					break;
				case 2:
					break;
				}
			}
		}
	}

	/**
	 * Search for the Tweet
	 */
	public void searchTweet() {
		System.out.println("Enter the tweet to search :");
		String keyword = sc.next();
		List<Tweet> tweets = datastore.searchTweet(keyword);
		if (tweets.isEmpty()) {
			System.out.println("No tweets are posted yet");
		} else {
			for (Tweet tweet : tweets) {
				System.out.println("User: " + tweet.getAuthor().getuserName() + "\nTweet: " + tweet.getContent()
						+ "\nTweetID: " + tweet.getId() + "\nLike: " + tweet.getLikescount() + "\nRetweet: "
						+ tweet.getRetweetscount() + "\nReply: " + tweet.getRepliescount());

				int choice;
				do {
					System.out.println("1.Like \n2.Retweet \n3.Reply \n4.Home");
					System.out.println("\nEnter your choice: ");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						if (tweet.getLikes().isEmpty()) {
							System.out.println("No Likes");
						} else {
							for (User likes : tweet.getLikes()) {
								System.out.println(likes.getuserName());
							}
						}
						System.out.println("1:To Like \n2:Exit ");
						int likechoice = sc.nextInt();
						switch (likechoice) {
						case 1:
							like(tweet);
							break;
						}
						break;
					case 2:
						if (tweet.getRetweets().isEmpty()) {
							System.out.println("No Retweets");
						} else {
							for (Map.Entry<String, User> retweet : tweet.retweets.entrySet()) {
								System.out.println(retweet.getKey() + "    " + retweet.getValue().getuserName());
							}
						}
						System.out.println("1:To Retweet \n2:Exit ");
						int retweetchoice = sc.nextInt();
						switch (retweetchoice) {
						case 1:
							retweet(tweet);
							break;
						}
						break;
					case 3:
						if (tweet.getReplies().isEmpty()) {
							System.out.println("No Replies");
						} else {
							for (Map.Entry<String, User> replies : tweet.replies.entrySet()) {
								System.out.println(replies.getKey() + "    " + replies.getValue().getuserName());
							}
						}
						System.out.println("1:To Reply \n2:Exit ");
						int replychoice = sc.nextInt();
						switch (replychoice) {
						case 1:
							reply(tweet);
							break;
						}
						break;
					case 4:
						System.out.println("Home");
						break;
					default:
						System.out.println("Invalid input...");
					}
				} while (choice != 4);
			}

		}
	}

	/**
	 * Add likes to tweet
	 * 
	 * @param tweet
	 */
	public void like(Tweet tweet) {
		tweet.likes(datastore.getUser(currentuser));
	}

	/**
	 * Add Retweets to the Tweet
	 * 
	 * @param tweet
	 */
	public void retweet(Tweet tweet) {
		System.out.println("Add your Retweet: ");
		String retweet = sc.nextLine();
		retweet += sc.nextLine();
		tweet.retweet(retweet, datastore.getUser(currentuser));
	}

	/**
	 * Add Replays to the Tweet
	 * 
	 * @param tweet
	 */
	public void reply(Tweet tweet) {
		System.out.println("Add your Reply: ");
		String reply = sc.nextLine();
		reply += sc.nextLine();
		tweet.reply(reply, datastore.getUser(currentuser));
	}

	/**
	 * View the Tweet timeline
	 */
	public void getTimeline() {
		User User = datastore.getUser(currentuser);
		List<Tweet> timeline = User.getTimeline();
		System.out.println("Your timeline:");
		for (Tweet tweet : timeline) {
			System.out.println("tweet: " + tweet.getContent() + "   Time: " + tweet.getTimestamp());
		}
	}

	/**
	 * View the Profile Page of the current Login user
	 */
	public void getProfile() {
		User User = datastore.getUser(currentuser);
		System.out.println("UserName:  " + User.getuserName());
		System.out.println("Name:      " + User.getName());
		System.out.println("bio:       " + User.getbio());
		System.out.println("Followers: " + User.getfollowersCount());
		System.out.println("Following: " + User.getfollowingsCount());
		System.out.println("Tweets:    " + User.gettweetsCount());
		int choice;
		do {
			System.out.println("1.Followers \n2.Followings \n3.Tweets \n4.Home");
			System.out.println("\nEnter your choice: ");
			choice = sc.nextInt();
			switch (choice) {

			case 1:
				if (User.getfollowers().isEmpty()) {
					System.out.println("No Followers");
				} else {
					for (User user : User.getfollowers()) {
						System.out.println(user.getuserName());
					}
				}
				break;

			case 2:
				if (User.getfollowings().isEmpty()) {
					System.out.println("No Followings");
				} else {
					for (User user : User.getfollowings()) {
						System.out.println(user.getuserName());
					}
					System.out.println("To UnFollow click y");
					String click = sc.next();
					if (click.equalsIgnoreCase("y")) {
						unFollow();
					}
				}
				break;

			case 3:
				if (User.getTweets().isEmpty()) {
					System.out.println("No Tweets");
				} else {
					for (Tweet tweet : User.getTweets()) {
						System.out.println(tweet.getContent() + "  " + tweet.getTimestamp());
					}
					System.out.println("To Delete Tweet click y");
					String click = sc.next();
					if (click.equalsIgnoreCase("y")) {
						deletetweet();
					}
				}
				break;

			case 4:
				System.out.println("Home");
				break;
			default:
				System.out.println("Invalid input...");
			}
		} while (!(choice == 4));

	}

	/**
	 * Post the Tweets
	 */
	private void postTweet() {
		System.out.println("Write a tweet :");
		String content = sc.nextLine();
		content += sc.nextLine();
		User User = datastore.getUser(currentuser);
		Tweet tweet = new Tweet(datastore.generateTweetID(), content, User);
		User.postTweet(tweet);
		System.out.println("Tweet posted successfully!!");
	}

	/**
	 * Delete the posted tweets
	 */
	public void deletetweet() {

		System.out.println("please enter delete tweet");

		String deletetweet = sc.next();
		User User = datastore.getUser(currentuser);

		Iterator<Tweet> itr = User.getTweets().iterator();

		while (itr.hasNext()) {

			Tweet deltwet = itr.next();

			if (deltwet.getContent().equals(deletetweet)) {

				User.deleteTweet(deltwet);

				System.out.println("Tweet Deleted Sucessfully...");

				break;

			}

		}
	}

	/**
	 * UnFollow the users whome the current login user is following
	 */
	public void unFollow() {

		System.out.println("please enter the username");

		String username = sc.next();
		User User = datastore.getUser(currentuser);

		Iterator<User> itr = User.getfollowings().iterator();

		while (itr.hasNext()) {

			User unfoll = itr.next();

			if (unfoll.getuserName().equals(username)) {

				User.unfollow(unfoll);

				System.out.println("UnFollow Sucessfully...");

				break;

			}

		}

	}

	private void userMenu(String name) {
		System.out.println("Welcome [" + name + "]!");
		boolean logout = false;
		while (!logout) {
			System.out.println(
					" 1. Post a tweet \n 2. View your timeline \n 3. Search for users \n 4. Search for tweets \n 5. View your profile \n 6. Logout");
			System.out.println("Enter your choice :");
			int choice = sc.nextInt();
			System.out.println();
			switch (choice) {
			case 1:
				postTweet();
				break;
			case 2:
				getTimeline();
				break;
			case 3:
				searchUser();
				break;
			case 4:
				searchTweet();
				break;
			case 5:
				getProfile();
				break;
			case 6:
				logout = logout();
				currentuser = null;
				System.out.println("Logout Successfully Done!!\n");
				break;

			}

		}

	}

}
