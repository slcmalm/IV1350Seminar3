package se.kth.iv1350.sale.view;

import se.kth.iv1350.sale.controller.Controller;
import se.kth.iv1350.sale.model.Amount;

/**
  * The View class represents the View layer and is currently hard coded.
  *
  */
public class View {
	private Controller contr;
	/**
	 * Initializes the View.
	 * @param contr The applications Controller.
	 */
	public View(Controller contr) {
		this.contr = contr;
	}
	
	/**
	 * This method implements a hard coded example of the application.
	 */
	public void SaleProcessExample() {
		contr.startNewSale();
		System.out.println("1. Starting new sale");
		
		//Adding potatoes
		int itemID = 2;
		int itemQuantity = 4;
		System.out.println("3. Registering potatoes, quantity of: " + String.valueOf(itemQuantity));
		String saleInfo = contr.registerItem(itemID, itemQuantity); 
		System.out.println(saleInfo.toString());		
		
		//Adding carrots
		itemID = 4;
		itemQuantity = 3;
		System.out.println("5. Registering carrots, quantity of: " + String.valueOf(itemQuantity));	
		saleInfo = contr.registerItem(itemID, itemQuantity); 
		System.out.println(saleInfo.toString());		
		
		//Adding invalid item
		itemID = 1;
		itemQuantity = 2;
		System.out.println("5. Registering invalid item, quantity of: " + String.valueOf(itemQuantity));	
		saleInfo = contr.registerItem(itemID, itemQuantity); 
		System.out.println(saleInfo.toString());		
		
		//Discount is requested
		int customerID = 1;
		Amount priceAfterDiscount = contr.getDiscount(customerID);
		System.out.println("6. Requesting discount");		
		System.out.println("7. Running total after discount: " + String.valueOf(priceAfterDiscount.getValue()));		

		int amountPaid = 50;
		System.out.println("8. Processing payment");
		float change = contr.processPayment(new Amount(amountPaid)).getValue();
		System.out.println("9. Amount of change provided to the View: " + String.valueOf(change));

	}
	
}
