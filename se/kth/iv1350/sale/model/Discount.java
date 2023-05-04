package se.kth.iv1350.sale.model;

/**
 * This class represents a discount and contains a discount percentage and a description.
 *
 */
class Discount {

	private Amount amount;
	private String description;
	/**
	 * Initializes and creates a Discount. The Discount fetches its values from the DiscountDTO.
	 * @param discount A DiscountDTO containing the values to transfer to this Discount.
	 */
	Discount(DiscountDTO discount) {
		this.amount = discount.amount;
		this.description = discount.description;
	}
	
	/**
	 * Initializes an empty discount object.
	 */
	Discount() {
		this.amount = new Amount(0);
		this.description = "";
	}
	
	/**
	 * Returns the discount amount, represented as a value between 0.0 to 1.0. 
	 * A value of 0.0 represents a 0% discount, and a value of 1.0 represents a 100% discount.
	 * @return The discount amount.
	 */
	Amount getAmount() {
		return amount;
	}

	/**
	 * Sets the discount amount, represented as a value between 0.0 to 1.0. 
	 * A value of 0.0 represents a 0% discount, and a value of 1.0 represents a 100% discount.
	 * @param amount The discount amount.
	 */
	void setAmount(Amount amount) {
		this.amount = amount;
	}
	
}
