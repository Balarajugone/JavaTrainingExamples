package com.javatraining.assignment3;

import java.time.LocalDateTime;





/**represent a vehicle rental transaction**/

 

public class Rental

{

    private VehicleDetails rentedVehicle ;

    private CustomerDetails customer;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

	public Rental(CustomerDetails customer, VehicleDetails vehicle, LocalDateTime startTime, LocalDateTime endTime) {

		this.customer = customer;
		this.rentedVehicle = vehicle;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public VehicleDetails getRentedVehicle() {
		return rentedVehicle;
	}


	public CustomerDetails getCustomer() {
		return customer;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}


	public LocalDateTime getEndTime() {
		return endTime;
	}

    

}