package com.epam.bigdata.flowershop.decorator;

import com.epam.bigdata.flowershop.item.Item;

public class BasketDecorator extends ItemDecorator {

	public BasketDecorator(Item item) {
		super(item);
	}

	@Override
	public String getDescription() {
		return (item.getDescription() + "\nBasket added.");
	}

	@Override
	public double getPrice() {
		return (10 + item.getPrice());
	}

}
