package com.epam.bigdata.flowershop.menu.confirm_order_menu;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

import com.epam.bigdata.flowershop.menu.IMenuCommand;
import com.epam.bigdata.flowershop.menu.exit_menu.Return;
import com.epam.bigdata.flowershop.order.Order;
import com.epam.bigdata.flowershop.singleton_scanner.SingletonScanner;

public class ConfirmOrderMenu implements IMenuCommand {

	private Map<Integer, IMenuCommand> inputCommands = new HashMap<>();
	
	private IMenuCommand commChooseDelivery;
	private IMenuCommand commChoosePayment;
	private IMenuCommand commConfirmOrder;
	private IMenuCommand commReturn;
	
	public ConfirmOrderMenu(Order order) {
		
		commChooseDelivery = new DeliveryOptions(order);
		commChoosePayment = new PaymentOptions(order);
		commConfirmOrder = new OrderConfirmation(order);
		commReturn = new Return();
				
		inputCommands.put(commChooseDelivery.getCommand(), commChooseDelivery);
		inputCommands.put(commChoosePayment.getCommand(), commChoosePayment);
		inputCommands.put(commConfirmOrder.getCommand(), commConfirmOrder);
		inputCommands.put(commReturn.getCommand(), commReturn);
	}

	@Override
	public void execute() {
		while(true){			
			try{	
				System.out.println("\n=======================================");
				System.out.println("Press 1 to choose delivery method");
				System.out.println("Press 2 to choose payment method");
				System.out.println("Press 3 to confirm your order");
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
		return 3;
	}
}
