package com.javatraining.assignment1;

import java.util.Scanner;

public class Transaction {
	Scanner sc=new Scanner(System.in);
	Accounts_arr ac=new Accounts_arr();
	 int choice;
	public void account() {
		
			System.out.println("Enter the account number");
			int acc_no=sc.nextInt();
			ac.setAccount_num(acc_no);
			System.out.println("Enter the pin number");
			int pin=sc.nextInt();
			ac.setPin(pin);
			System.out.println("Enter the balance");
			int balance=sc.nextInt();
			ac.setBalance(balance);
			
	}
	
	
	public void login() {
		System.out.println("Enter the account number");
		int acc_no=sc.nextInt();
			System.out.println("Enter the pin number");
			int pin=sc.nextInt();
			if(ac.login(acc_no,pin)) {
				do {
		            System.out.println("Welcome "+acc_no);
		            System.out.println("1. Check Balance");
		            System.out.println("2. Deposit");
		            System.out.println("3. Withdraw");
		            System.out.println("4. View Transaction History");
		            System.out.println("5. Exit");
		            System.out.print("Choose an option: ");
		            choice = sc.nextInt();

		            switch (choice) {
		                case 1:
		                    System.out.println("Current balance: $" + ac.checkBalance(acc_no));
		                    break;
		                case 2:
		                    System.out.print("Enter deposit amount: $");
		                    double depositAmount = sc.nextDouble();
		                    ac.deposit(depositAmount,acc_no);
		                    break;
		                case 3:
		                    System.out.print("Enter withdrawal amount: $");
		                    double withdrawalAmount = sc.nextDouble();
		                    ac.withdraw(withdrawalAmount,acc_no);
		                    break;
		                case 4:
		                    ac.TransactionHistory();
		                    break;
		                case 5:
		                    System.out.println("Thank you!");
		                    break;
		                default:
		                    System.out.println("Invalid option. Please try again.");
		            }

		            System.out.println();

		        } while (choice != 5);
			}
	}
	 
}
