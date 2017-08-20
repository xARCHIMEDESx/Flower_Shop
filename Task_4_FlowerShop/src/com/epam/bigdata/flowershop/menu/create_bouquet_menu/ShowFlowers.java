package com.epam.bigdata.flowershop.menu.create_bouquet_menu;

import java.util.HashMap;
import java.util.InputMismatchException;

import com.epam.bigdata.flowershop.item.Bouquet;
import com.epam.bigdata.flowershop.menu.IMenuCommand;
import com.epam.bigdata.flowershop.plant.Plant;
import com.epam.bigdata.flowershop.singleton_scanner.SingletonScanner;
import com.epam.bigdata.flowershop.xml_factory.Warehouse;

public class ShowFlowers implements IMenuCommand{

	private Warehouse warehouse;
	private HashMap<Integer, Plant> availablePlants;
	private final String warehouseAddress = "flowers.xml";
		
	public ShowFlowers() {
		warehouse = new Warehouse(warehouseAddress);
		availablePlants = warehouse.update();	
	}

	private void bouquetFormation(int id) {	
		Plant p;
		p = availablePlants.get(id);
		if(!p.equals(null)) {	
			((Bouquet) BouquetMenu.bouquet).addPlant(p);
		}		
	}


	@Override
	public void execute() {
		System.out.println("\n---------------------------------------");
		for (int i = 1; i <= availablePlants.size(); i++)
		{
		    System.out.println("Press " + i + " to choose: " + availablePlants.get(i).toString());
		}				
		System.out.println("\nPress 0 to return\n");	
		
		while(true){	
			try {					
				System.out.print("Please, choose a flower to add: ");
				int id = SingletonScanner.getInstance().nextInt();					
		
				if (id == 0) {
					break;
				}
					
				bouquetFormation(id);				
			}
			
			catch(ClassCastException ex) {
				System.err.println("You cannot add flowers to already decorated bouquet");
				SingletonScanner.getInstance().next();
				break;
			}
				
			catch(InputMismatchException | NullPointerException ex){
				System.err.println("\nWrong input. Try again.");		
				SingletonScanner.getInstance().next();
				execute();
				break;
			}
		}	
	}

	@Override
	public int getCommand() {
		return 1;
	}
	
}
