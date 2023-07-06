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

	/**
	 * 
	 * @return
	 * Return the Tweet Id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @return
	 * Return the tweet content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 
	 * @return
	 * Return the User details who wrote the tweet
	 */
	public User getAuthor() {
		return author;
	}

	/**
	 * Return the TimeStamp of the Tweet
	 * @return
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Add the Likes
	 * @param user
	 */
	public void likes(User user) {
		likes.add(user);

	}
	/**
	 * Add the Retweets for the tweet
	 * @param retweet
	 * @param user
	 */
	public void retweet(String retweet, User user) {
		retweets.put(retweet, user);
		
	} 
	/**
	 * Add the Replays for the tweet
	 * @param reply
	 * @param user
	 */
	public void reply(String reply, User user) {
		replies.put(reply, user);
		
	} 
	
	/**
	 * 
	 * @return
	 * Return the number of likes for the tweet
	 */
	public int getLikescount() {
		return likes.size();
	}

	/**
	 * 
	 * @return
	 * Return the number of Retweets for the tweet
	 */
	public int getRetweetscount() {
		return retweets.size();
	}

	/**
	 * 
	 * @return
	 * Return the number of eplays for the tweet
	 */
	public int getRepliescount() {
		return replies.size();
	}
	
	/**
	 * 
	 * @return
	 * Return the Users who liked the tweet
	 */
	public Set<User> getLikes() {
		return likes;
	}

	/**
	 * 
	 * @return
	 *  Return the Users who Retweet for the tweet
	 */
	public HashMap<String, User> getRetweets() {
		return retweets;
	}

	/**
	 * 
	 * @return
	 *  Return the Users who Replayed for the tweet
	 */
	public HashMap<String, User> getReplies() {
		return replies;
	}
	
}
