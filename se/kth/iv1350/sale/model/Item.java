package se.kth.iv1350.sale.model;

/**
 * This class represents an item.
 */

class Item {
	private int itemID;
	private String name;
	private String description;
	private Amount priceBeforeVAT;
	private Amount VATRate;
	
	/**
	 * Initializes and creates an Item using the values from an ItemDTO,
	 * @param item An ItemDTO containing the values to transfer to this Item.
	 */
	Item(ItemDTO item) {
		itemID = item.itemID;
		name = item.name;
		description = item.description;
		priceBeforeVAT = item.priceBeforeVAT;
		VATRate = item.VATRate;
	}
	
	/**
	 * Calculates and returns the total price of this Item, including VAT.
	 * @return The total price of this Item.
	 */
	Amount getTotalPrice() {
		Amount VATModifier = new Amount(1);
		VATModifier = VATModifier.add(VATRate);
		Amount totalPrice = priceBeforeVAT.multiply(VATModifier);
		return totalPrice;
	} 

	/**
	 * Fetches the price of this Item before VAT.
	 * @return
	 */
	Amount getPriceBeforeVAT() {
		return priceBeforeVAT;
	} 
	
	/**
	 * Creates and returns an ItemDTO containing the same field values as this Item.
	 * @return An ItemDTO containing the same field values as this Item.
	 */
	ItemDTO getDTO() {
		return new ItemDTO(itemID, name, description, priceBeforeVAT, getTotalPrice(), VATRate);
	}
}
