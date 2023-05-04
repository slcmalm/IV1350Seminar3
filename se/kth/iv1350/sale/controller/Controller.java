package se.kth.iv1350.sale.controller;

import se.kth.iv1350.sale.integration.CashRegister;
import se.kth.iv1350.sale.integration.DiscountDatabase;
import se.kth.iv1350.sale.integration.ExternalAccountingSystem;
import se.kth.iv1350.sale.integration.ExternalInventorySystem;
import se.kth.iv1350.sale.integration.ExternalSystemCreator;
import se.kth.iv1350.sale.integration.Printer;
import se.kth.iv1350.sale.model.Purchase;
import se.kth.iv1350.sale.model.PurchaseDTO;
import se.kth.iv1350.sale.model.ReceiptDTO;
import se.kth.iv1350.sale.model.ItemDTO;
import se.kth.iv1350.sale.model.Payment;
import se.kth.iv1350.sale.model.Amount;
import se.kth.iv1350.sale.model.DiscountDTO;

/**
 * The application's controller. All of the calls to the model layer passes through the controller. 
 * The controller also interacts with the external inventory system, accounting system, discount database and printer.
 */
public class Controller {
	
	private DiscountDatabase discountDatabase;
	private ExternalInventorySystem inventorySys;
	private ExternalAccountingSystem accountingSys;
	private Printer printer;
	private CashRegister register;
	private Purchase currentPurchase;
	
	/**
	 * Initializes the controller and fetches the external systems.
	 * @param externalSystems The external systems/databases which the Controller interacts with.
	 */
	public Controller (ExternalSystemCreator externalSystems) {
		inventorySys = externalSystems.getInventorySystem();
		discountDatabase = externalSystems.getDiscountDB();
		accountingSys = externalSystems.getAccountingSystem();
		printer = externalSystems.getPrinter();	
		register = externalSystems.getRegister();
	}
	
	/**
	 * Intializes the sales process for a single purchase.
	 */
	public void startNewSale() {
		currentPurchase = new Purchase();
	}
	
	/**
	 * Registers an item of a certain quantity in the current sale. Returns an error message if the itemID is invalid.
	 * @param itemID The ID of the items
	 * @param quantity The quantity of the items
	 * @return The current purchase description.
	 */
	public String registerItem(int itemID, int quantity) {
		boolean isValid = inventorySys.getItemValidity(itemID);
		ItemDTO item = inventorySys.getItem(itemID);
		String itemDescription = currentPurchase.addItem(item, quantity, isValid);
		return itemDescription;
	}
	
	/**
	 * Ends the sale and returns the running total.
	 * @return The running total of the purchase as a String.
	 */
	public Amount endSale() {
		return currentPurchase.getRunningTotal();
	}
	
	/**
	 * Checks if the current purchase is eligible for a discount. 
	 * @param customerID
	 * @return The running total after the discount is applied.
	 */
	public Amount getDiscount(int customerID) {
		PurchaseDTO saleInfo = currentPurchase.getPurchaseDTO();
		DiscountDTO discount = discountDatabase.fetchDiscount(saleInfo, customerID);
		currentPurchase.setDiscount(discount);
		return currentPurchase.getRunningTotal();
	}
	
	/**
	 * Processes the payment and returns the amount of change.
	 * @param amountPaid The amount that the customer has provided to the cashier.
	 * @return The amount of change that the cashier should provide to the customer.
	 */
	public Amount processPayment(Amount amountPaid) {
		PurchaseDTO saleInfo = currentPurchase.getPurchaseDTO();
		Payment payment = new Payment(saleInfo);
		Amount change = payment.getChangeAmount(amountPaid);
		payment.logSale();
		updateExternalSystems(saleInfo);	
		printReceipt(payment);
		return change;
	}
	
	private void updateExternalSystems(PurchaseDTO saleInfo) {
		inventorySys.updateInventory(saleInfo);
		accountingSys.record(saleInfo);
		register.updateAvailableCashAmount(currentPurchase.getRunningTotal());
	}
	
	private void printReceipt(Payment payment) {
		ReceiptDTO receipt = payment.getReceipt();
		printer.print(receipt);
		System.out.println(receipt.toString());		
	}

}
