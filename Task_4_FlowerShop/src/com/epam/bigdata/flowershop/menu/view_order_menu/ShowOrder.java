package com.epam.bigdata.flowershop.menu.view_order_menu;

import com.epam.bigdata.flowershop.menu.IMenuCommand;
import com.epam.bigdata.flowershop.order.Order;

public class ShowOrder implements IMenuCommand {
	private Order order;
	
	public ShowOrder(Order order) {
		this.order = order;
	}

	@Override
	public void execute() {
		try {			
			for(int i = 0; i < order.getOrder().size(); i++) {
				System.out.println("\nBouquet #" + (i+1));
				System.out.println(order.getOrder().get(i).getDescription());
				System.out.println("Bouquet price is: " + String.format("%.2f", order.getOrder().get(i).getPrice()) + "₴");
			}			
		} 
		catch (Exception ex) {
			System.err.println(ex.getMessage());
		}			
	}

	@Override
	public int getCommand() {
		return 1;
	}

}
