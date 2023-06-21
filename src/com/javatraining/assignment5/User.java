package com.javatraining.assignment5;

import java.util.*;

public class User {
	String userName;
	String password;
	String name;
	String bio;
	private final Set<User> followings= new HashSet<>();
	private final Set<User> followers=new HashSet<>();
	private final List<Tweet> tweets=new ArrayList<>();

	public User(String userName, String password, String name, String bio) {
		this.userName=userName;
		this.password=password;
		this.name=name;
		this.bio=bio;
	}

	public String getuserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getbio() {
		return bio;
	}
	public int getfollowingsCount() {
		return followings.size();
	}
	public Set<User> getfollowings() {
		return followings;
	}
	public int getfollowersCount() {
		return followers.size();
	}
	public Set<User> getfollowers() {
		return followers;
	}
	public int gettweetsCount() {
		return tweets.size();
	}

	public boolean isfollow(User user) {
		if(followers.contains(user)) {
			return true;
		}
		return false;
	}
	public void follow(User user) {
		followers.add(user);
		user.followings.add(this);

	}

	public void unfollow(User user) {
		followers.remove(user);
		user.followings.remove(this);
	}

	public void postTweet(Tweet tweet) {
		tweets.add(tweet);
	}

	public  List<Tweet> getTweets() {
		return tweets;
	}

	public void deleteTweet(Tweet tweet) {
		tweets.remove(tweet);
	}
	
	public List<Tweet> getTimeline() {
        List<Tweet> timeline=new ArrayList<>();
        for(User following:followings) {
            timeline.addAll(following.getTweets());
        }
        timeline.addAll(tweets);
        timeline.sort(Comparator.comparing(Tweet::getTimestamp).reversed());
        return timeline;

    }

}
