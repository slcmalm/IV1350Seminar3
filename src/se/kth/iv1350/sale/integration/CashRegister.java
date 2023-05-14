package se.kth.iv1350.sale.integration;

import se.kth.iv1350.sale.model.Amount;

/**
 * This class represents a physical cash register.
 *
 */
public class CashRegister {

	private Amount availableCash;
	/**
	 * Initializes the cash register with an amount of 1000 cash units.
	 */
	public CashRegister() {
		availableCash = new Amount(1000);
	}
	
	/**
	 * Adds the given amount of cash to the available cash in the register
	 * @param amount
	 */
	public void updateAvailableCashAmount(Amount amount) {
		availableCash = availableCash.add(amount);
	}
}
