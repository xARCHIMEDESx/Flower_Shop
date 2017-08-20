package com.epam.bigdata.flowershop.payment;

public interface IPayment {

	void pay(double price);
	String getDescription();
}
