package com.javatraining.assignment7;

public class NotificationService {
	/**
	 * Notify about the event
	 * 
	 * @param user
	 * @param item
	 */
	public void notifyUser(User user, Item item) {
		UserObserver userObserver = new UserObserver(user);
		userObserver.update(item);
	}
}
