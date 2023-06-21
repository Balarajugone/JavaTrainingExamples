package com.javatraining.assignment5;

import java.util.*;

public class Tweet {
	String id;
	String content;
	User author;
	Date timestamp;
	
	final HashMap<String,User> replies= new HashMap<>();
	final HashMap<String,User> retweets= new HashMap<>();
	//private final Set<User> retweets=new HashSet<>();
	private final Set<User> likes=new HashSet<>();
	//private final List<User> replies=new ArrayList<>();

	Tweet(String id, String content,User author){
		this.id=id;

		this.content=content;

		this.author=author;

		this.timestamp=new Date();
	}

	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public User getAuthor() {
		return author;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void likes(User user) {
		likes.add(user);

	} 
	public void retweet(String retweet, User user) {
		retweets.put(retweet, user);
		
	} 
	public void reply(String reply, User user) {
		replies.put(reply, user);
		
	} 
	
	public int getLikescount() {
		return likes.size();
	}

	public int getRetweetscount() {
		return retweets.size();
	}

	public int getRepliescount() {
		return replies.size();
	}
	
	public Set<User> getLikes() {
		return likes;
	}

	public HashMap<String, User> getRetweets() {
		return retweets;
	}

	public HashMap<String, User> getReplies() {
		return replies;
	}
	
}
