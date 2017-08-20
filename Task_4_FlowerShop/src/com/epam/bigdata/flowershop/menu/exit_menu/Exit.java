package com.epam.bigdata.flowershop.menu.exit_menu;

import com.epam.bigdata.flowershop.menu.IMenuCommand;

public class Exit implements IMenuCommand {

	@Override
	public void execute() {
		System.out.println("Good bye!");
		System.exit(0);
	}

	@Override
	public int getCommand() {
		return 4;
	}

}
