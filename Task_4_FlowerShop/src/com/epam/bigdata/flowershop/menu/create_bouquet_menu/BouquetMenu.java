package com.epam.bigdata.flowershop.menu.create_bouquet_menu;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

import com.epam.bigdata.flowershop.item.Bouquet;
import com.epam.bigdata.flowershop.item.Item;
import com.epam.bigdata.flowershop.menu.IMenuCommand;
import com.epam.bigdata.flowershop.menu.exit_menu.Return;
import com.epam.bigdata.flowershop.order.Order;
import com.epam.bigdata.flowershop.singleton_scanner.SingletonScanner;

public class BouquetMenu implements IMenuCommand{
	
	public static Item bouquet = new Bouquet();	
	
	private Map<Integer, IMenuCommand> inputCommands = new HashMap<>();
	private IMenuCommand commChooseFlower;
	private IMenuCommand commChooseDecorator;
	private IMenuCommand commBouquetToOrder;
	private IMenuCommand commReturn;
	
	public BouquetMenu(Order order) {
		
		commChooseFlower = new ShowFlowers();
		commChooseDecorator = new ShowDecorations();
		commBouquetToOrder = new AddItemToOrder(order);
		commReturn = new Return();
		
		inputCommands.put(commChooseFlower.getCommand(), commChooseFlower);
		inputCommands.put(commChooseDecorator.getCommand(), commChooseDecorator);
		inputCommands.put(commBouquetToOrder.getCommand(), commBouquetToOrder);
		inputCommands.put(commReturn.getCommand(), commReturn);		
	}

	@Override
	public void execute() {			
		while(true){			
			try{	
				System.out.println("\n=======================================");
				System.out.println("Press 1 to choose flowers");
				System.out.println("Press 2 to choose decoration");
				System.out.println("Press 3 to add this bouquet to your order");
				System.out.println("Press 0 to return");
				System.out.print("Make your choice: ");
				
				int userInput = SingletonScanner.getInstance().nextInt();
				inputCommands.get(userInput).execute();					
			}
		
			catch(InputMismatchException | NullPointerException ex){
				System.err.println("\nWrong input. Try again");
				SingletonScanner.getInstance().next();
			}
		}		
	}


	@Override
	public int getCommand() {
		return 1;
	}
}
