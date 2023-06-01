package com.javatraining.assignment2;

import java.util.Scanner;

public class Process {
	Library lb=new Library();
	Scanner sc=new Scanner(System.in);
	
	int choice;
	String title;
	String aut;
	String patron;
	
	public void addBook() {
		if(lb.bookcount()) {
			System.out.println("Enter book title:");
			title=sc.next();
			System.out.println("Enter author:");
			aut=sc.next();
			lb.addBooks(title, aut);
		}
		else {
			System.out.println("You are unable to add more books..");
            System.out.println("please choose another option");
		}
		
	}
	
	public void addPatron() {
	if(lb.patronscount()) {
		System.out.println("Enter patron name :");
		patron=sc.next();
		lb.addPatrons(patron);
	}
	else {
		System.out.println("You are unable to add more patrons..");
        System.out.println("please choose another option");
	}
	}
	
	public void barrowBook() {
		System.out.println("Enter patron name :");
		patron=sc.next();
		System.out.println("Enter book title:");
		title=sc.next();
		lb.barrowBooks(title, patron);
	}
	
	public void returnBook() {
		System.out.println("Enter book title:");
		title=sc.next();
		lb.returnBook(title);
	}
}
