package com.epam.bigdata.flowershop.decorator;

import com.epam.bigdata.flowershop.item.Item;

public class PaperDecorator extends ItemDecorator {
	
	public PaperDecorator(Item item) {
		super(item);
	}

	@Override
	public String getDescription() {
		return (item.getDescription() + "\nPaper added.");
	}

	@Override
	public double getPrice() {
		return (5 + item.getPrice());
	}

}
