package com.epam.bigdata.flowershop.menu.main_menu;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

import com.epam.bigdata.flowershop.menu.IMenuCommand;
import com.epam.bigdata.flowershop.menu.confirm_order_menu.ConfirmOrderMenu;
import com.epam.bigdata.flowershop.menu.create_bouquet_menu.BouquetMenu;
import com.epam.bigdata.flowershop.menu.exit_menu.Exit;
import com.epam.bigdata.flowershop.menu.view_order_menu.ViewOrderMenu;
import com.epam.bigdata.flowershop.order.Order;
import com.epam.bigdata.flowershop.singleton_scanner.SingletonScanner;

public class MainMenu {	
	private static Map<Integer, IMenuCommand> inputCommands = new HashMap<>();	
	private IMenuCommand commChooseBouquet;
	private IMenuCommand commViewOrder;
	private IMenuCommand commConfirmOrder;
	private IMenuCommand commExit;


	public MainMenu(){
		Order order = new Order();
		
		commChooseBouquet = new BouquetMenu(order);
		commViewOrder = new ViewOrderMenu(order);
		commConfirmOrder = new ConfirmOrderMenu(order);
		commExit = new Exit();		
		
		inputCommands.put(commChooseBouquet.getCommand(), commChooseBouquet);
		inputCommands.put(commViewOrder.getCommand(), commViewOrder);
		inputCommands.put(commConfirmOrder.getCommand(), commConfirmOrder);
		inputCommands.put(commExit.getCommand(), commExit);
	}

	public static void showMenu(){
		System.out.println("\n\t\t\t===Welcome to Flower Shop v2.0===");
		while(true){			
			try{				
				System.out.println("Press 1 to Create a bouquet");
				System.out.println("Press 2 to View your order list");
				System.out.println("Press 3 to Confirm your order");
				System.out.println("Press 4 to Exit");
				System.out.print("Make your choice: ");
				
				int userInput = SingletonScanner.getInstance().nextInt();
				inputCommands.get(userInput).execute();	
				
			}
		
			catch(InputMismatchException | NullPointerException ex){
				System.err.println("\nWrong input. Try again");
				SingletonScanner.getInstance().next();
				showMenu();		
				break;
			}
		}
	}
}
