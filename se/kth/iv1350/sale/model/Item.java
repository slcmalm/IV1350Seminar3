package se.kth.iv1350.sale.model;

/**
 * 
 * @author Sophie
 *
 */
public class Item {
	private int itemID;
	private String name;
	private String description;
	
	//Should the price be represented by a class?
	private Amount totalPrice;
	private Amount priceBeforeVAT;
	private Amount VAT;
	
	/**
	 * 
	 */
	public Item(ItemDTO item) {
		itemID = item.itemID;
		name = item.name;
		description = item.description;
		
		totalPrice = item.totalPrice;
		priceBeforeVAT = item.priceBeforeVAT;
		VAT = item.VAT;
	}
	
	/**
	 * 
	 * @return
	 */
	public Amount getTotalPrice() {
		return totalPrice;
	} 

	/**
	 * 
	 * @return
	 */
	public ItemDTO getDTO() {
		return new ItemDTO(itemID, name, description, totalPrice, priceBeforeVAT, VAT);
	}
}
