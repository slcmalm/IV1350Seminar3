package se.kth.iv1350.sale.integration;
import java.util.HashMap;
import java.util.Map;

import se.kth.iv1350.sale.model.Amount;
import se.kth.iv1350.sale.model.DiscountDTO;
import se.kth.iv1350.sale.model.PurchaseDTO;

/**
 * This class represents the external database which contains all of the 
 * available discounts.
 */
public class DiscountDatabase {
	private Map<Integer,DiscountDTO> discounts = new HashMap<Integer,DiscountDTO>();
	
	/**
	 * Initializes the discount database.
	 */
	public DiscountDatabase() {
		discounts.put(1, new DiscountDTO(new Amount(15), "Example discount"));
	}
	
	/**
	 * Fetches a discount from the database.
	 * @param saleInfo The current purchase.
	 * @param customerID The customer ID.
	 * @return The discount applicable to the purchase.
	 */
	public DiscountDTO fetchDiscount(PurchaseDTO saleInfo, int customerID) {
		if(discounts.containsKey(customerID)) {
			return discounts.get(customerID);
		}
		else return new DiscountDTO(new Amount(0), "No discount applicable");		
	}
	
}
