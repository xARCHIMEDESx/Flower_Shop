package com.epam.bigdata.flowershop.payment;

public class CreditCardPaymentStrategy implements IPayment {

	@Override
	public void pay(double price) {
		// Payment processing...
		System.out.println("Payed by credit card");
	}

	@Override
	public String getDescription() {
		return ("Credit card payment");
	}

}
