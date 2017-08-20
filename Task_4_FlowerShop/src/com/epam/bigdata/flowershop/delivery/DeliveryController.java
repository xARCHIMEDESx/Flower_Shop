package com.epam.bigdata.flowershop.delivery;

import java.util.ArrayList;
import java.util.List;

public class DeliveryController {

	private List<IDelivery> deliveryOptions = new ArrayList<>();
	
	public DeliveryController() {
		deliveryOptions.add(new DHLDeliveryStrategy());
		deliveryOptions.add(new PostDeliveryStrategy());		
	}
	
	public List<IDelivery> getDeliveryOptions(){
		return deliveryOptions;
	}
	
}
