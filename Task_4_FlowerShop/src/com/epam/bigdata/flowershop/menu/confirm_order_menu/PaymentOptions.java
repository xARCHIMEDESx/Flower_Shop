package com.epam.bigdata.flowershop.menu.confirm_order_menu;

import java.util.InputMismatchException;

import com.epam.bigdata.flowershop.menu.IMenuCommand;
import com.epam.bigdata.flowershop.order.Order;
import com.epam.bigdata.flowershop.payment.*;
import com.epam.bigdata.flowershop.singleton_scanner.SingletonScanner;

public class PaymentOptions implements IMenuCommand {

	private Order order;
	private PaymentController paymentOptions;

	public PaymentOptions(Order order) {
		this.order = order;
		paymentOptions = new PaymentController();
	}

	private void choosePayment(int id) {
		IPayment payment = paymentOptions.getPaymentOptions().get(id-1);
		order.setPaymentStrategy(payment);
		System.out.println("---" + payment.getDescription());
	}
	
	@Override
	public void execute() {
		while(true){	
			try {
				System.out.println("\n---------------------------------------");
				for (int i = 1; i <= paymentOptions.getPaymentOptions().size(); i++){
				    System.out.println("Press " + i + " to choose: " + paymentOptions.getPaymentOptions().get(i-1).getDescription());
				}	
				System.out.println("Press 0 to return");
				System.out.print("\nMake your choice: ");
				int id = SingletonScanner.getInstance().nextInt();					
		
				if (id == 0) {
					break;
				}
					
				choosePayment(id);	
				break;
			}
				
			catch(InputMismatchException | IndexOutOfBoundsException ex){
				System.err.println("\nWrong input. Try again.");		
				SingletonScanner.getInstance().next();
			}
		}		
	}

	@Override
	public int getCommand() {
		return 2;
	}

}
