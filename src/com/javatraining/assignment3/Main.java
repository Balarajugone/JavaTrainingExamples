package com.javatraining.assignment3;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		RentalService rs=new RentalService();
		CustomerDetails customerdetails=new CustomerDetails();
		List<VehicleDetails> vehicles;
		Rental rent = null;
        int choice = 0;
        int vehicle_choice = 0;

        do

        {

                System.out.println("Vehicle Rental Management System");

                System.out.println("1.Add Vehicle");

                System.out.println("2.List Available vehicles");

                System.out.println("3.Rent a vehicle");

                System.out.println("4.Calculate rental cost");

                System.out.println("5.Return vehicle");

                System.out.println("6.Quit");

                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                switch(choice)

                {

                case 1:
                	do

                    {

                            System.out.println("Which type of vachile you want to add");

                            System.out.println("1.Car");

                            System.out.println("2.Bicycle");
                            
                            System.out.println("3.motorcycle");
                            
                            System.out.println("4.Quit");
                            vehicle_choice = sc.nextInt();

                            switch(vehicle_choice)

                            {
                            case 1:
                            	Car car=new Car();
                            	car.addVehicle();
                            	rs.addVehicle(car);
                            	System.out.println("\nCar details added successfully...\n");
                                break;

                            case 2:
                            	Bicycle bicycle=new Bicycle();
                            	bicycle.addVehicle();
                            	rs.addVehicle(bicycle);
                            	System.out.println("\nBicycle details added successfully...\n");
                                break;

                            case 3:
                            	Motorcycle motorcycle=new Motorcycle();
                            	motorcycle.addVehicle();
                            	rs.addVehicle(motorcycle);
                            	System.out.println("\nMotorcycle details added successfully...\n");
                                break;
                           case 4:
                        	  System.out.println("Quit: ");
                            	break;
                            	
                          default:

                                System.out.println("Invalid option");	
                            }
                   
                	   
                   

                    }

                    while(vehicle_choice!=4);

                    System.out.println("\nThank you for adding vechiles...\n");
                	break;

                case 2:
                	vehicles=rs.getAvailableVehicles();
                	if(vehicles.isEmpty()) {
                		System.out.println("\nNo vehicles are added, Please add the vehicles...\n");
                	}else {
                		for(VehicleDetails vehicle:vehicles) {
                			
                    		System.out.println(vehicle.getVehicleID()+" - "+vehicle.getMake()+" - "+vehicle.getModel()+" - "+vehicle.getYear()+"\n");
                    	}
                	}
                    break;

                case 3:
                	vehicles=rs.getAvailableVehicles();
                	System.out.println("Enter vahicle name");
                	String vahicle_name= sc.next();
                	if(vehicles.isEmpty()) {
                		System.out.println("\nNo vehicles are added, Please add the vehicles...\n");
                	}else {
                	for(VehicleDetails vehicle:vehicles) {
                		//System.out.println("vehicle is "+vehicle.getModel());
                	if(vehicle.equals(rs.avaialbility(vahicle_name))) {
                		customerdetails.addCustomer();
                		System.out.println("Enter start year");
                		int stryear=sc.nextInt();
                		System.out.println("Enter start month");
                    	int strmonth=sc.nextInt();
                    	System.out.println("Enter start day");
                    	int strday=sc.nextInt();
                    	System.out.println("Enter start hour");
                    	int strhour=sc.nextInt();
                    	System.out.println("Enter start minute");
                    	int strminute=sc.nextInt();
                    	LocalDateTime starttime = LocalDateTime.of(stryear,strmonth,strday,strhour,strminute);
                    	System.out.println("Enter end year");
                    	int endyear=sc.nextInt();
                    	System.out.println("Enter end month");
                    	int endmonth=sc.nextInt();
                    	System.out.println("Enter end day");
                    	int endday=sc.nextInt();
                    	System.out.println("Enter end hour");
                    	int endhour=sc.nextInt();
                    	System.out.println("Enter end minute");
                    	int endminute=sc.nextInt();
                    	LocalDateTime endtime = LocalDateTime.of(endyear,endmonth,endday,endhour,endminute);
                		rent = rs.rentVehicle(customerdetails, vehicle, starttime, endtime);
                	}
                	}
                	}
                    break;

                case 4:
                	BigDecimal cost = rs.calculateRentalCost(rent);
                	System.out.println("\nCalculate rental cost: "+cost+"\n");
                	break;
                case 5:
                	rs.returnVehicle(rent.getRentedVehicle());
                	System.out.println("\nvehicle returned sucessfully...\n ");
                	break;
                case 6:
                	System.out.println("Quit: ");
                	break;

                default:

                    System.out.println("\nInvalid option\n");

                }


        }

        while(choice!=6);

        System.out.println("\nThank you for using our service, Please visit again...\n");

        sc.close();
	}
}
