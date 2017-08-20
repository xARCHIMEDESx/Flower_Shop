package com.epam.bigdata.flowershop.payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentController {
	
	private List<IPayment> paymentOptions = new ArrayList<>();
	
	public PaymentController() {
		paymentOptions.add(new CreditCardPaymentStrategy());
		paymentOptions.add(new PayPalPaymentStrategy());
	}
	
	public List<IPayment> getPaymentOptions(){
		return paymentOptions;
	}

}
