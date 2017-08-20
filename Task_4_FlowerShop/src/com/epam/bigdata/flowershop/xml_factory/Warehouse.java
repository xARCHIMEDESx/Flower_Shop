package com.epam.bigdata.flowershop.xml_factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.epam.bigdata.flowershop.comparator.FlowerComparator;
import com.epam.bigdata.flowershop.plant.Plant;

public class Warehouse {

	private HashMap<Integer, Plant> plantsInTheWarehouse = new HashMap<>();
			
	public Warehouse(String path) {
		FlowerFactory.loadData(path);		
	}
	
	public HashMap<Integer, Plant> update() {	
		List<Plant> plantList = new ArrayList<>();
		plantList.addAll(FlowerComparator.compareByName(FlowerFactory.flowerParsing()));		
		plantList.addAll(FlowerComparator.compareByName(FlowerFactory.cactusParsing()));
	
		for(int i = 0; i < plantList.size(); i++) {
			plantsInTheWarehouse.put(i+1, plantList.get(i));
		}
		
		return plantsInTheWarehouse;
	}
	
}
