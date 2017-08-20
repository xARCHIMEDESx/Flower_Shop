package com.epam.bigdata.flowershop.menu.confirm_order_menu;

import com.epam.bigdata.flowershop.menu.IMenuCommand;
import com.epam.bigdata.flowershop.order.Order;

public class OrderConfirmation implements IMenuCommand {
	private Order order;

	public OrderConfirmation(Order order) {
		this.order = order;
	}

	@Override
	public void execute() {
		try {
			System.out.println("\n");
			order.processOrder();
			System.out.println("Total price is: " + String.format("%.2f", order.calculateTotalPrice()) + "₴");
			System.out.println("Thank you!!!");
			System.exit(0);
		}
		
		catch(NullPointerException ex) {
			System.err.println("You must choose delivery and payment methods first!");			
		}
		catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	@Override
	public int getCommand() {
		return 3;
	}

}
