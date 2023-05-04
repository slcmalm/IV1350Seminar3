package se.kth.iv1350.sale.model;

/**
 * This class is a data transfer object for the Discount class. 
 * It contains a discount amount and a description.
 */

public class DiscountDTO {

	public Amount amount;
	public String description;
	
	/**
	 * Initializes and creates a discountDTO using a discount amount and a description.
	 * @param amount The discount amount, represented as a value between 0.0 to 1.0. 
	 * A value of 0.0 represents a 0% discount, and a value of 1.0 represents a 100% discount.
	 * @param description A description of this discount.
	 */
	public DiscountDTO(Amount amount, String description) {
		this.amount = amount;
		this.description = description;
	}

}
