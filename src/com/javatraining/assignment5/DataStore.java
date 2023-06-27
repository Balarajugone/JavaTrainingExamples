package com.javatraining.assignment5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;



public class DataStore {

	private final HashMap<String, User> users;


	public DataStore() {
		this.users=new HashMap<>();
	}

	public boolean isUserExists(String username) {
		return users.containsKey(username);
	}

	public User getUser(String username) {
		return users.get(username);
	}

	public void addUser(User user) {
		users.put(user.getuserName(), user);
	}

	public List<User> searchUsers(String username){

		List<User> result=new ArrayList<>();
		for(User user: users.values()) {
			if(user.getuserName().contains(username)) {
				result.add(user);
			}
		}
		return result;

	}

	public List<Tweet> searchTweet(String keyword) {
		List<Tweet> result=new ArrayList<>();
		for(User user:users.values()) {
			for(Tweet tweet:user.getTweets() ){
				if(tweet.getContent().contains(keyword)) {
					result.add(tweet);
				}else {
					System.out.println("Tweet doesn't Exist...");
					break;
				}
			}
		}
		return result;
	}

	public String generateTweetID() {
        // Generate a unique tweet ID using a timestamp or any other method you prefer
        UUID uuid=UUID.randomUUID();
        return uuid.toString();
    }
}
