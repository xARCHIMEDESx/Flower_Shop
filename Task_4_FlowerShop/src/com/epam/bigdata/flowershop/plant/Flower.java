package com.epam.bigdata.flowershop.plant;

public class Flower extends Plant{
		
	private double stemLength;
	private double hoursFromCutting;
	
	public double getStemLength() {
		return stemLength;
	}
	
	public double getHoursFromCutting() {
		return hoursFromCutting;
	}
	
	public void setStemLength(double stemLength) {
		this.stemLength = stemLength;
	}
	
	public void setHoursFromCutting(double hoursFromCutting) {
		this.hoursFromCutting = hoursFromCutting;		
	}

	@Override
	public String toString() {
		return ("Type: " + getClass().getSimpleName() + ",  Name: "+ getName() + ",  Price: " + 
				String.format("%.2f", getPrice()) + "₴" + ",  Stem length: " + getStemLength() + "cm" + 
				",  Freshness: " + getHoursFromCutting() + " hours");
	}
}
