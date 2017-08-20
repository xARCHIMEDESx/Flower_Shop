package com.epam.bigdata.flowershop.menu.view_order_menu;

import java.util.InputMismatchException;

import com.epam.bigdata.flowershop.menu.IMenuCommand;
import com.epam.bigdata.flowershop.order.Order;
import com.epam.bigdata.flowershop.singleton_scanner.SingletonScanner;

public class DeleteItemFromOrder implements IMenuCommand{

private Order order;
	
	public DeleteItemFromOrder(Order order) {
		this.order = order;
	}

	@Override
	public void execute() {
		while(true){	
			try {
				order.getOrder();
				System.out.println("\n---------------------------------------");
				System.out.println("Choose the number of bouquet you want to remove from your order list");
				System.out.println("Press 0 to return");
				System.out.print("\nMake your choice: ");
				int id = SingletonScanner.getInstance().nextInt();					
		
				if (id == 0) {
					break;
				}
					
				order.removeItem(order.getOrder().get(id-1));
				System.out.println("---Bouquet #" + id + " was removed");
				break;
			}
		
				
			catch(InputMismatchException ex){
				System.err.println("\nWrong input. Try again.");		
				SingletonScanner.getInstance().next();
			}
			
			catch (IndexOutOfBoundsException ex) {
				System.err.println("There is no bouquet with such index in your order");
			} 
			catch (Exception ex) {
				System.err.println(ex.getMessage());
				break;
			}	
		}		
		
	}

	@Override
	public int getCommand() {
		return 2;
	}
}
