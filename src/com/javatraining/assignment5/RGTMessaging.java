package com.javatraining.assignment5;

import java.util.*;

public class RGTMessaging {
	Scanner sc=new Scanner(System.in);
	String currentuser;
	DataStore datastore;

	RGTMessaging(){
		datastore = new DataStore();
	}

	public void registerUser() {
		System.out.println("\nEnter UserName: ");
		String userName=sc.next();
		System.out.println("\nEnter Password: ");
		String password=sc.next();
		System.out.println("\nEnter Name: ");
		String name=sc.next();
		System.out.println("\nEnter bio: ");
		String bio=sc.next();
		if (datastore.isUserExists(userName)) {
			System.out.println("Username already exists. Please choose a different username.");
		} else {
			User User = new User(userName, password, name, bio);
			datastore.addUser(User);
			System.out.println("User registered successfully!!");
		}
	}
	public void login() {
		System.out.println("\nEnter UserName: ");
		String uName=sc.next();
		System.out.println("\nEnter Password: ");
		String password=sc.next();
		User User=datastore.getUser(uName);
		if(User!=null && User.getPassword().equals(password)) {
			currentuser=User.getuserName();
			userMenu(User.getName());
		}else {
			System.out.println("\nUserName or Password invalid, Please try again ");
		}
	}
	public boolean logout() {
		return true;
	}
	public void searchUser() {
		System.out.println("Enter UserName: ");
		String uName=sc.next();
		User User=datastore.getUser(uName);
		if(User==null) {
			System.out.println("UserName doesn't Exist...");
		}else {
			System.out.println("UserName:  "+User.getuserName());
			System.out.println("Name:      "+User.getName());
			System.out.println("bio:       "+User.getbio());
			System.out.println("Followers: "+User.getfollowersCount());
			System.out.println("Following: "+User.getfollowingsCount());
			System.out.println("Tweets:    "+User.gettweetsCount());
			if(!User.isfollow(datastore.getUser(currentuser))) {
				System.out.println("To follow click 1 \nTo skip click 2 \nchoose your option");
				int follow=sc.nextInt();
				switch(follow) {
				case 1:User.follow(datastore.getUser(currentuser));
				break;
				case 2: break;
				}
			}else {
				System.out.println("To unfollow click 1 \nTo skip click 2 \nchoose your option");
				int unfollow=sc.nextInt();
				switch(unfollow){
				case 1:User.unfollow(datastore.getUser(currentuser));
				break;
				case 2: break;
				}
			}
		}
	}
	public void searchTweet() {
		System.out.println("Enter the tweet to search :");
		String keyword=sc.next();
		List<Tweet> tweets=datastore.searchTweet(keyword);
		if(tweets.isEmpty()) {
			System.out.println("No tweets are posted yet");
		}else {
			for(Tweet tweet:tweets) {
				System.out.println("User: "+tweet.getAuthor().getuserName()+"\nTweet: "+tweet.getContent()+"\nTweetID: "+tweet.getId()+"\nLike: "+tweet.getLikescount()
				+"\nRetweet: "+tweet.getRetweetscount()+"\nReply: "+tweet.getRepliescount());

				int choice;
				do {
					System.out.println("1.Like \n2.Retweet \n3.Reply \n4.Home");
					System.out.println("\nEnter your choice: ");
					choice=sc.nextInt();
					switch (choice) {
					case 1:if(tweet.getLikes().isEmpty()) {
						System.out.println("No Retweets");
					}else {
						for(User likes:tweet.getLikes()) {
							System.out.println(likes.getuserName());
						}
					}
					System.out.println("1:To Like \n2:Exit ");
					int likechoice=sc.nextInt();
					switch (likechoice) {
					case 1:like(tweet);
					break;
					}
					break;
					case 2:if(tweet.getRetweets().isEmpty()) {
						System.out.println("No Retweets");
					}else {
						for(Map.Entry<String, User> retweet:tweet.retweets.entrySet()) {
							System.out.println(retweet.getKey()+"    "+retweet.getValue().getuserName());
						}
					}
					System.out.println("1:To Retweet \n2:Exit ");
					int retweetchoice=sc.nextInt();
					switch (retweetchoice) {
					case 1:retweet(tweet);
					break;
					}
					break;
					case 3: 
						if(tweet.getRetweets().isEmpty()) {
							System.out.println("No Retweets");
						}else {
							for(Map.Entry<String, User> replies:tweet.replies.entrySet()) {
								System.out.println(replies.getKey()+"    "+replies.getValue().getuserName());
							}
						}
						System.out.println("1:To Reply \n2:Exit ");
						int replychoice=sc.nextInt();
						switch (replychoice) {
						case 1:reply(tweet);
						break;
						}
						break;
					case 4: System.out.println("Home");
					break;
					default:
						System.out.println("Invalid input...");
					}
				}while(choice!=4);
			}

		}
	}

	public void like(Tweet tweet) {
		tweet.likes(datastore.getUser(currentuser));
	}
	public void retweet(Tweet tweet) {
		System.out.println("Add your Retweet: ");
		String retweet=sc.next();
		tweet.retweet(retweet,datastore.getUser(currentuser));
	}
	public void reply(Tweet tweet) {
		System.out.println("Add your Reply: ");
		String reply=sc.next();
		tweet.reply(reply,datastore.getUser(currentuser));
	}

	public void getTimeline() {
		User User=datastore.getUser(currentuser);
		List<Tweet> timeline=User.getTimeline();
		System.out.println("Your timeline:");
		for(Tweet tweet:timeline) {
			System.out.println("tweet: "+tweet.getContent()+"   Time: "+tweet.getTimestamp());
		}
	}

	public void getProfile() {
		User User=datastore.getUser(currentuser);
		System.out.println("UserName:  "+User.getuserName());
		System.out.println("Name:      "+User.getName());
		System.out.println("bio:       "+User.getbio());
		System.out.println("Followers: "+User.getfollowersCount());
		System.out.println("Following: "+User.getfollowingsCount());
		System.out.println("Tweets:    "+User.gettweetsCount());
		int choice;
		do {
			System.out.println("1.Followers \n2.Followings \n3.Tweets \n4.Home");
			System.out.println("\nEnter your choice: ");
			choice=sc.nextInt();
			switch (choice) {
			case 1: for(User user:User.getfollowers()) {
				System.out.println(user.getuserName());
			}
			break;
			case 2: for(User user:User.getfollowings()) {
				System.out.println(user.getuserName());
			}
			break;
			case 3: for(Tweet tweet:User.getTweets()) {
				System.out.println(tweet.getContent());
			}
			break;
			case 4: System.out.println("Home");
			break;
			default:
				System.out.println("Invalid input...");
			}
		}while(!(choice==4));

	}

	private void postTweet() {
		System.out.println("Write a tweet :");
		String content = sc.next();
		User User=datastore.getUser(currentuser);
		Tweet tweet = new Tweet(datastore.generateTweetID(), content, User);
		User.postTweet(tweet);
		System.out.println("Tweet posted successfully!!");
	}

	private  void userMenu(String name) {
		System.out.println("Welcome ["+name+"]!");
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
				logout=logout();
				currentuser = null;
				System.out.println("Logout Successfully Done!!\n");
				break;

			}

		}

	}

}
