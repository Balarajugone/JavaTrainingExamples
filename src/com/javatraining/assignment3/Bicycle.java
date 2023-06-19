package com.javatraining.assignment3;

import java.util.*;

public class Bicycle extends VehicleDetails{
	Scanner sc = new Scanner(System.in);
	
	@Override
    public void addVehicle()

    {
		
		System.out.print("Enter the vehicle Id: ");

		setVehicleID(sc.next());
		setAvailable(true);

		System.out.print("Enter the make Id: ");
		
		setMake(sc.next());
		
		System.out.print("Enter the model Id: ");
		
		setModel(sc.next());
		
		System.out.print("Enter the year Id: ");
		
		setYear(sc.nextInt());
		
    }
}
