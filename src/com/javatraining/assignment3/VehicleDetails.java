package com.javatraining.assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class VehicleDetails implements VehicleOperations {
	
	private String licensePlate;

	private String make;

	private String model;

	private int year;

	private boolean isAvailable;


	public String getVehicleID()

	{

		return licensePlate;

	}

	public void setVehicleID(String vehicleID)

	{

		this.licensePlate = vehicleID;

	}

	public String getMake()

	{

		return make;

	}

	public void setMake(String make)

	{

		this.make = make;

	}

	public String getModel()

	{

		return model;

	}

	public void setModel(String model)

	{

		this.model = model;

	}

	public int getYear()

	{

		return year;

	}

	public void setYear(int year)

	{

		this.year = year;

	}


	public boolean isAvailable()

	{
		return isAvailable;

	}

	public void setAvailable(boolean isAvailable)

	{

		this.isAvailable = isAvailable;

	}



	public abstract void addVehicle();
}
