package com.epam.bigdata.flowershop.menu.exit_menu;

import com.epam.bigdata.flowershop.menu.IMenuCommand;
import com.epam.bigdata.flowershop.menu.main_menu.MainMenu;

public class Return implements IMenuCommand {

	@Override
	public void execute() {
		MainMenu.showMenu();
	}

	@Override
	public int getCommand() {
		return 0;
	}
}
