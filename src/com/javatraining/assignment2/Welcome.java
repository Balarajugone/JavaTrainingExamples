package com.javatraining.assignment2;

import java.util.Scanner;


public class Welcome {

	public static void main(String[] args) {
		Process p=new Process();
		Scanner sc=new Scanner(System.in);
		int choice;
		System.out.println("Welcome to Library Management System");
		do {
			System.out.println("1:Add Book");
			System.out.println("2:Add Patron");
			System.out.println("3:Barrow Book");
			System.out.println("4:Return Book");
			System.out.println("5:Exit");
			System.out.println("Enter your choice: ");

			choice=sc.nextInt();
			switch (choice) {
			case 1: {
				p.addBook();
				break;
			}
			case 2: {
				p.addPatron();
				break;
			}
			case 3: {
				p.barrowBook();
				break;
			}
			case 4: {
				p.returnBook();
				break;
			}
			case 5: {
				System.out.println("Good bye...");
				break;
			}
			default:
				System.out.println("Invalid option");
			}
		}while(choice!=5);
		System.out.println("Thank you for using our library service, Please visit again...");
		sc.close();
	}

}
