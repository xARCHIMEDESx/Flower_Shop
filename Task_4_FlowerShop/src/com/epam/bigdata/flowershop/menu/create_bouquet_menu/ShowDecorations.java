package com.epam.bigdata.flowershop.menu.create_bouquet_menu;

import java.util.InputMismatchException;

import com.epam.bigdata.flowershop.decorator.*;
import com.epam.bigdata.flowershop.menu.IMenuCommand;
import com.epam.bigdata.flowershop.singleton_scanner.SingletonScanner;

public class ShowDecorations implements IMenuCommand {

	private void decoration(int id) {
		switch(id) {
		case 1: 
			BouquetMenu.bouquet = new RibbonDecorator(BouquetMenu.bouquet);
			showInfo();
			break;
		case 2: 
			BouquetMenu.bouquet = new PaperDecorator(BouquetMenu.bouquet);
			showInfo();
			break;
		case 3: 
			BouquetMenu.bouquet = new BasketDecorator(BouquetMenu.bouquet);
			showInfo();
			break;
		default:
			throw new IllegalArgumentException();
		}
	}
	
	private void showInfo() {
		System.out.println(BouquetMenu.bouquet.getDescription());
		System.out.println("New price is: " + BouquetMenu.bouquet.getPrice());
	}
	
	@Override
	public void execute() {		
		while(true){	
			try {
				System.out.println("\n---------------------------------------");
				System.out.println("Press 1 to add Ribbon");
				System.out.println("Press 2 to add Paper");
				System.out.println("Press 3 to add Basket");
				System.out.println("Press 0 to return");
				System.out.print("\nMake your choice: ");
				int id = SingletonScanner.getInstance().nextInt();					
		
				if (id == 0) {
					break;
				}
					
				decoration(id);				
			}
				
			catch(InputMismatchException | IllegalArgumentException ex){
				System.err.println("\nWrong input. Try again.");		
				SingletonScanner.getInstance().next();
			}
		}			
	}

	@Override
	public int getCommand() {
		return 2;
	}

}
