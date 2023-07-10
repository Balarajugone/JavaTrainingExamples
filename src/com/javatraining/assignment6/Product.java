package com.javatraining.assignment6;

import java.io.Serializable;

public class Product implements Serializable{
	String name;
	String description;
	String price;
	String quantity;
	public Product(String name,String description,String price,String quantity) {
		this.name=name;
		this.description=description;
		this.price=price;
		this.quantity=quantity;
	}
	public void equals() {
		
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getPrice() {
		return price;
	}
	public String getQuantity() {
		return quantity;
	}
	public String toString() {
		return "Products [Name :"+name+"	 Description: "+description+" 	Price: "+price+" 	quantity: "+quantity+"]";
		
	}
}
