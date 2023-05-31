package com.javatraining.assignment1;

import java.util.Scanner;

public class Accounts_arr {
	private int[] account_num;
	private int ac_count;
	private int pin_count;
	private int bal_count;
	private int[] pin;
	private double[] balance;
	private double[] transactions;
	private int transactionCount;
	int acc_nums;
	int attempts;
	int pn;
	Scanner sc=new Scanner(System.in);
	public Accounts_arr() {
		balance = null;
		transactions = new double[100];
		transactionCount = 0;
		ac_count = 0;
		pin_count = 0;
		bal_count = 0;
		account_num = new int[100];
		pin = new int[100];
		balance = new double[100];

	}
	public boolean login(int ac_no,int pn) {
		this.pn=pn;
		for(int i=0;i<ac_count;i++) {
			if(ac_no==account_num[i]) {
				attempts=3;
				do {
					if(pn==pin[i]) {
						System.out.println("login sucessfull");
						return true;
					}else {
						attempts--;
						System.out.println("pin invalid");
						if(attempts>0) {
							System.out.println("you have "+attempts+" attempts left");
							System.out.println("Please enter the valid pin");
							pn=sc.nextInt();
						}
					}
				}while(attempts>0);
				System.out.println("Account is blocked, Please try after some time...");
			}
		}
		return false;
	}

	public void setAccount_num(int account_num) {
		this.account_num[ac_count++] = account_num;
	}

	public void setPin(int pin) {
		this.pin[pin_count++] = pin;
	}

	public void setBalance(int balance) {
		this.balance[bal_count++] = balance;
	}
	public double checkBalance(int acc_no) {
		for(int i=0;i<ac_count;i++) {
			acc_nums = account_num[i];
			if(acc_nums==acc_no) {
				return balance[i];
			}
		}
		return 0;
	}
	public void deposit(double amount,int acc_no) {
		for(int i=0;i<ac_count;i++) {
			acc_nums = account_num[i];
			if(acc_nums==acc_no) {
				if(amount>0) {
					balance[i]+=amount;
					transactions[transactionCount++]=amount;
				}else {
					System.out.println("Invalid deposit amount.");
				}
			}
		}
	}
	public void withdraw(double amount,int acc_no) {
		for(int i=0;i<ac_count;i++) {
			acc_nums = account_num[i];
			if(acc_nums==acc_no) {
				if (amount > balance[i]) {
					System.out.println("Insufficient balance.");
				} else if (amount <= 0) {
					System.out.println("Invalid withdrawal amount.");
				} else {
					balance[i] -= amount;
					transactions[transactionCount++] = -amount;
				}
			}
		}
	}

	public void TransactionHistory() {
		System.out.println("Transaction History:");
		if(transactionCount==0) {
			System.out.println("No Transaction has done");
		}
		for (int i = 0; i < transactionCount; i++) {
			if (transactions[i] > 0) {
				System.out.println("Deposit: $" + transactions[i]);
			} else {
				System.out.println("Withdraw: $" + (-transactions[i]));
			}
		}
	}

}
