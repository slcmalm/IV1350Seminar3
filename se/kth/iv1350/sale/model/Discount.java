package se.kth.iv1350.sale.model;

/**
 * 
 * @author Sophie
 *
 */
public class Discount {

	private Amount amount;
	private String description;
	/**
	 * 
	 * @param amount
	 */
	public Discount(DiscountDTO discount) {
		this.amount = discount.amount;
		this.description = discount.description;
	}
	
	/**
	 * Initializes an empty discount object.
	 */
	public Discount() {
		this.amount = new Amount(0);
		this.description = "";
	}
	
	/**
	 * 
	 * @return
	 */
	public Amount getAmount() {
		return amount;
	}

	/**
	 * 
	 * @param amount
	 */
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	
}
