package com.epam.bigdata.flowershop.payment;

public class PayPalPaymentStrategy implements IPayment {

	@Override
	public void pay(double price) {
		// Payment processing...
		System.out.println("Payed with Paypal");
	}

	@Override
	public String getDescription() {
		return ("PayPal payment");
	}

}
