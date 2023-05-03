package se.kth.iv1350.sale.model;

/**
 * 
 * @author Sophie
 *
 */
public class DiscountDTO {

	public Amount amount;
	public String description;
	
	/**
	 * 
	 * @param amount
	 * @param description
	 */
	public DiscountDTO(Amount amount, String description) {
		this.amount = amount;
		this.description = description;
	}

}
