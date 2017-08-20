package com.epam.bigdata.flowershop.order;

import java.util.LinkedList;
import java.util.List;

import com.epam.bigdata.flowershop.delivery.IDelivery;
import com.epam.bigdata.flowershop.item.Item;
import com.epam.bigdata.flowershop.payment.IPayment;

public class Order {

	private List<Item> itemList = new LinkedList<>();
	private IPayment payment;
	private IDelivery delivery;
	
	public void setPaymentStrategy(IPayment payment) {
		this.payment = payment;
	}
	
	public void setDeliveryStrategy(IDelivery delivery) {
		this.delivery = delivery;
	}
	
	public double calculateTotalPrice() {
		double totalPrice = 0.00;
		for(Item item : itemList) {
			totalPrice += item.getPrice();
		}
		return totalPrice;
	}
	
	public void processOrder() throws Exception {
		if(itemList.isEmpty()) {
			throw new Exception("\nYour order list is empty!");
		}
		payment.pay(calculateTotalPrice());
		delivery.deliverOrder(itemList);
	}
	

	public List<Item> getOrder() throws Exception {
		if(itemList.isEmpty()) {
			throw new Exception("\nYour order list is empty!");
		}
		return itemList;
	} 
	
	public void addItem(Item item) {
		itemList.add(item);
	}
	
	
	public void removeItem(Item item) {
		itemList.remove(item);
	}
}
