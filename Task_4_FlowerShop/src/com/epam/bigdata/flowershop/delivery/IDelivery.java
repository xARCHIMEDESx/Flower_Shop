package com.epam.bigdata.flowershop.delivery;

import java.util.List;

import com.epam.bigdata.flowershop.item.Item;

public interface IDelivery {

	void deliverOrder(List<Item> itemList);
	String getDescription();
}
