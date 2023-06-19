package com.javatraining.assignment3;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

 

public class RentalService implements RentalCostCalculator
{
	private List<VehicleDetails> vehicles;
    private List<Rental> rentals;
    
    RentalService(){
    	this.vehicles=new ArrayList<>();
    	this.rentals=new ArrayList<>();
    }
  
	public void addVehicle(VehicleDetails vehicle) 
    {
        vehicles.add(vehicle);

    }

    public List<VehicleDetails> getAvailableVehicles() 
    {
    	List<VehicleDetails> availableVehicles = new ArrayList<>();
    	for(VehicleDetails vehicle:vehicles) {
    		if(vehicle.isAvailable())
    		availableVehicles.add(vehicle);
    	}
        return availableVehicles;
    }
    public VehicleDetails avaialbility(String vechile) {
    	for(VehicleDetails vehicle:vehicles) {
    		if(vehicle.getModel().equalsIgnoreCase(vechile)) {
    			return vehicle;
    		}
    		else {
    			System.out.println("Vehicle is not available for rent");
    			return null;
    		}
    	}
		return null;
    }
    

    public Rental rentVehicle(CustomerDetails customer, VehicleDetails vehicle, LocalDateTime startTime, LocalDateTime endTime) 
    {
    	vehicles.remove(vehicle);
    	Rental Rental=new Rental(customer,vehicle,startTime,endTime);
        return Rental;

    }

	@Override
	public BigDecimal calculateRentalCost(Rental rental) {
		if(rental==null) {
			System.out.println("\nVehicle is not yet rented \n");
		}else {
		LocalDateTime startTime = rental.getStartTime();
        LocalDateTime endTime = rental.getEndTime();
        Duration duration = Duration.between(startTime, endTime);

        // Perform the calculation based on the duration
        long hours = duration.toHours();
        BigDecimal hourlyRate = BigDecimal.valueOf(10); // Assuming an hourly rate of Rs10

        BigDecimal rentalCost = hourlyRate.multiply(BigDecimal.valueOf(hours));

        // Return the calculated rental cost
        return rentalCost;
	}
		return null;
	}
    
	public void returnVehicle(VehicleDetails vehicleDetails) {
		vehicles.add(vehicleDetails);
		rentals.remove(vehicleDetails);
	}
    
}
