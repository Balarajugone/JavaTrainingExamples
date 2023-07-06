package com.javatraining.assignment7;

//UserObserver class (Observer)
/**
 * Observer Design pattern which update the event to all the observers
 * 
 * @author BalarajuGone
 *
 */
public class UserObserver implements Observer {

	private User user;

	/**
	 * Constructor for UserObserver class
	 * 
	 * @param user
	 */
	public UserObserver(User user) {
		this.user = user;
	}

	/**
	 * Update the event and Notify about the event to all the observers
	 */
	@Override
	public void update(Item item) {
		if (item.getHighestBidder() != null && !item.getHighestBidder().equals(user)) {
			System.out.println("You have been outbid on item: " + item.getName());
		}
	}

	/**
	 * 
	 * @return Return the User
	 */
	public User getUser() {
		return user;
	}

}
