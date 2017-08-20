package com.epam.bigdata.flowershop.item;

import java.util.ArrayList;
import java.util.List;

import com.epam.bigdata.flowershop.comparator.FlowerComparator;
import com.epam.bigdata.flowershop.plant.*;


public class Bouquet extends Item {
	
	private List<Plant> plantList = new ArrayList<>();

	public double getPrice() {
		double price = 0.00;
		for(Plant plant : plantList) {
			price += plant.getPrice();
		}
		return price;
	}
	
	public boolean searchFlower(String plantName){
		for(Plant plant : plantList) {
			if(plant.getName().equalsIgnoreCase(plantName)) {
				return true;
			}
		}
		return false;
	}
	
	public void addPlant(Plant plant) {
		plantList.add(plant);
	}
	
	public List<Plant> getBouquet(){
		return plantList;
	}

	public String getDescription() {
		String description = "The bouquet consists of:";
		
		for(Plant plant : plantList) {
			description += "\n"+plant.toString();
		}
		return description;
	}
	
	public void getFlowerWithTheLongestStem() {
		String flowerWithTheLongestStem;
		FlowerComparator.compareByStemLength(this);		
		try {
			flowerWithTheLongestStem = ((Flower) plantList.get(0)).getName();
			System.out.println("The flower with the longest stem your bouquet is: " + flowerWithTheLongestStem);
		}
		catch (ClassCastException ex) {
			System.out.println("There is no flower with a stem in the bouquet");
		}
		catch (IndexOutOfBoundsException ex) {
			System.out.println("You must choose at least one flower");
		}
	}
	
	public void getTheFreshestFlower() {
		String theFreshestFlower;	
		FlowerComparator.compareByHoursFromCutting(this);
		try {
			theFreshestFlower = ((Flower) plantList.get(0)).getName();
			System.out.println("The freshest flower in your bouquet is: " + theFreshestFlower);		
		}
		catch (ClassCastException ex) {
			System.out.println("There is no flower with freshness quality in the bouquet");
		}
		
		catch (IndexOutOfBoundsException ex) {
			System.out.println("You must choose at least one flower");
		}
	}

}
