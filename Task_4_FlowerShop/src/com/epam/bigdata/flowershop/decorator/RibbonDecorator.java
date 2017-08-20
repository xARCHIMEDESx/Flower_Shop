package com.epam.bigdata.flowershop.decorator;

import com.epam.bigdata.flowershop.item.Item;

public class RibbonDecorator extends ItemDecorator {

	public RibbonDecorator(Item item) {
		super(item);
	}

	@Override
	public String getDescription() {
		return (item.getDescription() + "\nRibbon added.");
	}

	@Override
	public double getPrice() {
		return (4 + item.getPrice());
	}

}
