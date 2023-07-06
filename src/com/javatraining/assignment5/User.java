package com.javatraining.assignment5;

import java.util.*;

public class User {
	String userName;
	String password;
	String name;
	String bio;
	private final Set<User> followings = new HashSet<>();
	private final Set<User> followers = new HashSet<>();
	private final List<Tweet> tweets = new ArrayList<>();

	/**
	 * Constructor for the User to assign the values to the variables
	 * 
	 * @param userName
	 * @param password
	 * @param name
	 * @param bio
	 */
	public User(String userName, String password, String name, String bio) {
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.bio = bio;
	}

	/**
	 * 
	 * @return Return the user name
	 */
	public String getuserName() {
		return userName;
	}

	/**
	 * 
	 * @return Return the Password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @return Return the Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return Return the Bio
	 */
	public String getbio() {
		return bio;
	}

	/**
	 * Get the following count, i.e how many number of users the user is following
	 * 
	 * @return Return the number of users the user is following
	 * 
	 */
	public int getfollowingsCount() {
		return followings.size();
	}

	/**
	 * 
	 * @return Return the User details who are following
	 */
	public Set<User> getfollowings() {
		return followings;
	}

	/**
	 * Get the followers count, i.e how many number of followers are there for the
	 * user
	 * 
	 * @return Return the number of followers for the user is having
	 */
	public int getfollowersCount() {
		return followers.size();
	}

	/**
	 * Get the followers of the user
	 * 
	 * @return Return the followers of the users
	 */
	public Set<User> getfollowers() {
		return followers;
	}

	/**
	 * Get the tweets count of the user
	 * 
	 * @return Return how many number of tweets are done for the user
	 */
	public int gettweetsCount() {
		return tweets.size();
	}

	/**
	 * If the current user is already following the other user
	 * 
	 * @param user
	 * @return Return the user is already following
	 */
	public boolean isfollow(User user) {
		if (followers.contains(user)) {
			return true;
		}
		return false;
	}

	/**
	 * follow the user
	 * 
	 * @param user
	 */
	public void follow(User user) {
		followers.add(user);
		user.followings.add(this);

	}

	/**
	 * unfollow the user if the user is already following
	 * 
	 * @param user
	 */
	public void unfollow(User user) {
		followings.remove(user);
		user.followers.remove(this);
	}

	/**
	 * Add the tweet to the list
	 * 
	 * @param tweet
	 */
	public void postTweet(Tweet tweet) {
		tweets.add(tweet);
	}

	/**
	 * 
	 * @return Return the available tweets
	 */
	public List<Tweet> getTweets() {
		return tweets;
	}

	/**
	 * Delete the tweet from the list
	 * 
	 * @param tweet
	 */
	public void deleteTweet(Tweet tweet) {
		tweets.remove(tweet);
	}

	/**
	 * 
	 * @return Return the Timeline
	 */
	public List<Tweet> getTimeline() {
		List<Tweet> timeline = new ArrayList<>();
		for (User following : followings) {
			timeline.addAll(following.getTweets());
		}
		timeline.addAll(tweets);
		timeline.sort(Comparator.comparing(Tweet::getTimestamp).reversed());
		return timeline;

	}

}
