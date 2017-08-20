package com.epam.bigdata.flowershop.menu.confirm_order_menu;

import java.util.InputMismatchException;

import com.epam.bigdata.flowershop.delivery.*;
import com.epam.bigdata.flowershop.menu.IMenuCommand;
import com.epam.bigdata.flowershop.order.Order;
import com.epam.bigdata.flowershop.singleton_scanner.SingletonScanner;

public class DeliveryOptions implements IMenuCommand{
	private Order order;
	private DeliveryController deliveryOptions;
	
	public DeliveryOptions(Order order) {
		this.order = order;
		deliveryOptions = new DeliveryController();
	}

	private void chooseDelivery(int id) {
		IDelivery delivery = deliveryOptions.getDeliveryOptions().get(id-1);
		order.setDeliveryStrategy(delivery);
		System.out.println("---" + delivery.getDescription());
	}
	
	@Override
	public void execute() {
		while(true){	
			try {
				System.out.println("\n---------------------------------------");
				for (int i = 1; i <= deliveryOptions.getDeliveryOptions().size(); i++){
				    System.out.println("Press " + i + " to choose: " + deliveryOptions.getDeliveryOptions().get(i-1).getDescription());
				}			
				System.out.println("Press 0 to return");
				System.out.print("\nMake your choice: ");
				int id = SingletonScanner.getInstance().nextInt();					
		
				if (id == 0) {
					break;
				}
					
				chooseDelivery(id);
				break;
			}
				
			catch(InputMismatchException | IndexOutOfBoundsException ex){
				System.err.println("\nWrong input. Try again.");		
				SingletonScanner.getInstance().next();
			}
		}		
	}

	@Override
	public int getCommand() {
		return 1;
	}

}
