package se.kth.iv1350.sale.integration;

/**
 * 
 * @author Sophie
 *
 */

public class ExternalSystemCreator {
	
	private DiscountDatabase discountDatabase;
	private ExternalInventorySystem inventorySys;
	private ExternalAccountingSystem accountingSys;
	private Printer printer;
	
	/**
	 * 
	 */
	public ExternalSystemCreator () {
		inventorySys = new ExternalInventorySystem();
		discountDatabase = new DiscountDatabase();
		accountingSys = new ExternalAccountingSystem();
		printer = new Printer();
	}
	
	/**
	 * 
	 * @return
	 */
	public ExternalInventorySystem getInventorySystem() {
		return inventorySys;
	}
	
	/**
	 * 
	 * @return
	 */
	public DiscountDatabase getDiscountDB() {
		return discountDatabase;
	}
	
	/**
	 * 
	 * @return
	 */
	public ExternalAccountingSystem getAccountingSystem() {
		return accountingSys;
	}
	
	/**
	 * 
	 * @return
	 */
	public Printer getPrinter() {
		return printer;
	}

}
