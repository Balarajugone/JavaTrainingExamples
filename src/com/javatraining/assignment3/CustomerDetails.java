package com.javatraining.assignment3;

import java.util.Scanner;

public class CustomerDetails {
	
	public int customerID;

    public String firstName;

    public String lastName;

    public String emailAddress;

    public long phoneNumber;
    
    Scanner sc = new Scanner(System.in);

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

    public void addCustomer() {
    	System.out.println("Enter Customer ID");
    	setCustomerID(sc.nextInt());
    	System.out.println("Enter firstName");
    	setFirstName(sc.next());
    	System.out.println("Enter lastName");
    	setLastName(sc.next());
    	System.out.println("Enter emailAddress");
    	setEmailAddress(sc.next());
    	System.out.println("Enter phoneNumber");
    	setPhoneNumber(sc.nextLong());
    }

    
}
