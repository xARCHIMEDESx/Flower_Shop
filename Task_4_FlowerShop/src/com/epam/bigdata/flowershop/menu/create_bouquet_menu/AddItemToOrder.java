package com.epam.bigdata.flowershop.menu.create_bouquet_menu;

import com.epam.bigdata.flowershop.menu.IMenuCommand;
import com.epam.bigdata.flowershop.menu.main_menu.MainMenu;
import com.epam.bigdata.flowershop.order.Order;

public class AddItemToOrder implements IMenuCommand {
	private Order order;
	
	public AddItemToOrder(Order order) {
		this.order = order;
	}

	@Override
	public void execute() {
			if((BouquetMenu.bouquet).getPrice() != 0){
				order.addItem(BouquetMenu.bouquet);	
				System.out.println("\n---Bouquet added to your order list.");	
				MainMenu.showMenu();
			}
			else {
				System.err.println("\nNothing to add!");
			}
	}

	@Override
	public int getCommand() {
		return 3;
	}

}
