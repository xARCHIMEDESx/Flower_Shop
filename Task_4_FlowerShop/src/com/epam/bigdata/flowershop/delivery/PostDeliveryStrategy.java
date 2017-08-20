package com.epam.bigdata.flowershop.delivery;

import java.util.List;
import com.epam.bigdata.flowershop.item.Item;

public class PostDeliveryStrategy implements IDelivery {

	@Override
	public void deliverOrder(List<Item> itemList) {
		System.out.println("Items will be delivered by post");
	}

	@Override
	public String getDescription() {
		return ("Post delivery");
	}

}
