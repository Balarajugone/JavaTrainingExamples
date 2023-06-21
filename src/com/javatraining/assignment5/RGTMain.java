package com.javatraining.assignment5;
import java.util.*;
public class RGTMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		RGTMessaging rgtm=new RGTMessaging();
		int choice;
		System.out.println("Welcome to RGTMessaging!");
		do {
			System.out.println("1.Register \n2.Login \n3.Exit");
			System.out.println("\nEnter your choice: ");
			choice=sc.nextInt();
			switch (choice) {
			case 1:rgtm.registerUser();
			        break;
			case 2: rgtm.login();
			        break;
			case 3: System.out.println("Thank you for using RGTMessage App");
			        break;
			default:
				System.out.println("Invalid input...");
			}
		}while(!(choice==3));
	}

}
