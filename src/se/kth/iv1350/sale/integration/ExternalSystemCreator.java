package se.kth.iv1350.sale.integration;

/**
 * This class creates all of the external systems and databases the application interacts with.
 */

public class ExternalSystemCreator {
	
	private DiscountDatabase discountDatabase;
	private ExternalInventorySystem inventorySys;
	private ExternalAccountingSystem accountingSys;
	private Printer printer;
	private CashRegister register;
	
	/**
	 * Initializes the ExternalSystemCreator and creates the external systems.
	 */
	public ExternalSystemCreator () {
		inventorySys = new ExternalInventorySystem();
		discountDatabase = new DiscountDatabase();
		accountingSys = new ExternalAccountingSystem();
		printer = new Printer();
		register = new CashRegister();
	}
	
	/**
	 * Returns the external inventory system.
	 * @return The external inventory system.
	 */
	public ExternalInventorySystem getInventorySystem() {
		return inventorySys;
	}
	
	/**
	 * Returns the external discount database.
	 * @return The external discount database.
	 */
	public DiscountDatabase getDiscountDB() {
		return discountDatabase;
	}
	
	/**
	 * Returns the external accounting system.
	 * @return The external accounting system.
	 */
	public ExternalAccountingSystem getAccountingSystem() {
		return accountingSys;
	}
	
	/**
	 * Returns the printer.
	 * @return The printer.
	 */
	public Printer getPrinter() {
		return printer;
	}
	
	/**
	 * Returns the cash register.
	 * @return The cash register.
	 */
	public CashRegister getRegister() {
		return register;
	}

}
