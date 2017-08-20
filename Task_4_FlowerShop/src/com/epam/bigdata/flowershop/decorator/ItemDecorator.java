package com.epam.bigdata.flowershop.decorator;

import com.epam.bigdata.flowershop.item.Item;

public abstract  class ItemDecorator extends Item {

	protected Item item;
	
	public ItemDecorator(Item item) {
		this.item = item;
	}
}
