package com.epam.bigdata.flowershop.delivery;

import java.util.List;
import com.epam.bigdata.flowershop.item.Item;

public class DHLDeliveryStrategy implements IDelivery {

	@Override
	public void deliverOrder(List<Item> itemList) {
		System.out.println("Items will be delivered by DHL");
	}

	@Override
	public String getDescription() {
		return ("DHL delivery");
	}

}
