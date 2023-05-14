package se.kth.iv1350.sale.view;

import se.kth.iv1350.sale.controller.Controller;
import se.kth.iv1350.sale.model.Amount;
import se.kth.iv1350.sale.model.PurchaseDTO;
import se.kth.iv1350.sale.model.ReceiptDTO;

/**
  * This class represents the View layer and is currently hard coded.
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
	 * This method implements a hard coded example of the Sale Process. It adds two different types of items to the purchase,
	 * and also tries to add an invalid item.
	 */
	public void SaleProcessExample() {
		//Starting the sale process
		contr.startNewSale();
		
		//Registering potatoes
		int itemID = 2;
		int itemQuantity = 4;
		PurchaseDTO saleInfo = contr.registerItem(itemID, itemQuantity); 
		System.out.println(saleInfo.toString());		
		
		//Registering carrots
		itemID = 4;
		itemQuantity = 3;
		saleInfo = contr.registerItem(itemID, itemQuantity); 
		System.out.println(saleInfo.toString());		
		
		//Trying to register an invalid item
		itemID = 1;
		itemQuantity = 2;
		saleInfo = contr.registerItem(itemID, itemQuantity); 
		System.out.println(saleInfo.toString());		
		
		//Requesting discount
		int customerID = 1;
		Amount priceAfterDiscount = contr.getDiscount(customerID);
		System.out.println("Running total after discount: " + String.valueOf(priceAfterDiscount.getValue()));		

		//Paying for the purchase
		int amountPaid = 50;
		ReceiptDTO receipt = contr.processPayment(new Amount(amountPaid));
		System.out.println(receipt.toString());
		System.out.println("Change amount: " + String.valueOf(receipt.getChangeAmount().getValue()));
	}
}
