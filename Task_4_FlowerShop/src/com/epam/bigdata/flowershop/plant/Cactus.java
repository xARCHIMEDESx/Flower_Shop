package com.epam.bigdata.flowershop.plant;

public class Cactus extends Plant{
	
	private String shape;

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	@Override
	public String toString() {
		return ("Type: " + getClass().getSimpleName() + ",  Name: "+ getName() + ",  Price: " + 
				String.format("%.2f", getPrice()) + "₴" + ",  Shape: " + getShape());
	}

}
