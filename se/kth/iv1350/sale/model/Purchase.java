package se.kth.iv1350.sale.model;

import java.time.LocalDateTime;

/**
 * This class represents a purchase and contains sale information, a list of items and the discount relevant to this purchase.
 */
public class Purchase {

	private java.time.LocalDateTime dateTimeOfSale;
	private ItemList itemList;
	private Discount discount;
	
	/**
	 * Initializes and creates a Purchase. Stores the current date and time of this purchase.
	 */
	public Purchase() {
		dateTimeOfSale = LocalDateTime.now();
		itemList = new ItemList();
		discount = new Discount();	
	}
		
	/**
	 * Adds an item to this purchase.
	 * @param item The item to be added to this purchase.
	 * @param quantity The quantity of the item to be added to this purchase.
	 * @param isValid The validity of the item.
	 * @return Returns the description of the item. Returns an error message if the item is invalid. 
	 */
	public String addItem(ItemDTO item, int quantity, boolean isValid) {
		if(isValid) {
			item = itemList.addItem(item, quantity); 
			return getItemDescriptionAndTotal(item);
		}
		else {
			return "Error: Invalid itemID. No items added to purchase";
		}
	}
	
	/**
	 * Creates and returns a PurchaseDTO containing the same field values as this Purchase.
	 * @return A PurchaseDTO containing the same field values as this Purchase.
	 */
	public PurchaseDTO getPurchaseDTO() {
		ItemDTO[] items = itemList.getDTOArray();
		return new PurchaseDTO(dateTimeOfSale, items, discount.getAmount(), getRunningTotal(), getTotalVAT());
	} 
	
	/**
	 * Calculates the running total after applying discounts.
	 * @return The running total of this purchase.
	 */
	public Amount getRunningTotal() {
		return calculateTotalAfterDiscount(itemList.getTotalPrice(), discount.getAmount());
	}
	
	/**
	 * Calculates the total amount of VAT after applying discounts.
	 * @return The total amount of VAT of this Purchase.
	 */
	public Amount getTotalVAT() {
		return calculateTotalAfterDiscount(itemList.getTotalVAT(), discount.getAmount());		
	}
	
	/**
	 * Calculates the running total as a String after applying discounts.
	 * @return The running total of this Purchase.
	 */
	public String getRunningTotalStr() {
		String str = "Running total: " + String.valueOf(getRunningTotal().getValue());
		return str;
	}
	
	/**
	 * Applies a discount to this purchase.
	 * @param discount The Discount to be added to this purchase.
	 */
	public void setDiscount(DiscountDTO discount) {
		this.discount = new Discount(discount);
	}

	private Amount calculateTotalAfterDiscount(Amount total, Amount discount) {
		Amount discountMultiplier = new Amount(1);
		discountMultiplier = discountMultiplier.subtract(discount);
		return total.multiply(discountMultiplier);
	}
	
	private String getItemDescriptionAndTotal(ItemDTO item) {
		String str = item.toString() + "\n" + getRunningTotalStr();
		return str;
	}
}
