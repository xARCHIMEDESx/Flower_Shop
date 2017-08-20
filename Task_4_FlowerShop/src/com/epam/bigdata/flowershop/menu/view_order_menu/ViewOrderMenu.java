package com.epam.bigdata.flowershop.menu.view_order_menu;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

import com.epam.bigdata.flowershop.menu.IMenuCommand;
import com.epam.bigdata.flowershop.menu.exit_menu.Return;
import com.epam.bigdata.flowershop.order.Order;
import com.epam.bigdata.flowershop.singleton_scanner.SingletonScanner;

public class ViewOrderMenu implements IMenuCommand {
	
	private Map<Integer, IMenuCommand> inputCommands = new HashMap<>();
	
	private IMenuCommand commShowOrder;
	private IMenuCommand commReturn;
	private IMenuCommand commDeleteItem;
	
	public ViewOrderMenu(Order order) {
		
		commShowOrder = new ShowOrder(order);
		commDeleteItem = new DeleteItemFromOrder(order);
		commReturn = new Return();
		
		inputCommands.put(commShowOrder.getCommand(), commShowOrder);
		inputCommands.put(commDeleteItem.getCommand(), commDeleteItem);
		inputCommands.put(commReturn.getCommand(), commReturn);
	}
	
	@Override
	public void execute() {
		while(true){			
			try{	
				System.out.println("\n=======================================");
				System.out.println("Press 1 to show your order list");
				System.out.println("Press 2 to remove an item from your order list");
				System.out.println("Press 0 to return");
				System.out.print("Make your choice: ");
				
				int userInput = SingletonScanner.getInstance().nextInt();
				inputCommands.get(userInput).execute();	
				
			}
		
			catch(InputMismatchException | NullPointerException e){
				System.err.println("\nWrong input. Try again");
				SingletonScanner.getInstance().next();
			}
		}		
	}

	@Override
	public int getCommand() {
		return 2;
	}

}
