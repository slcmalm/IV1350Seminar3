package se.kth.iv1350.sale.model;

/**
 * 
 * @author Sophie
 *
 */
public class ItemDTO {

	public int itemID;
	public String name;
	public String description;
	public Amount totalPrice;
	public Amount priceBeforeVAT;
	public Amount VAT;
	
	/**
	 * 
	 * @param name
	 * @param description
	 * @param itemID
	 * @param totalPrice
	 * @param priceBeforeVAT
	 * @param VAT
	 */
	public ItemDTO(int itemID, String name, String description, Amount totalPrice, Amount priceBeforeVAT, Amount VAT)
	{
		this.itemID = itemID;
		this.name = name;
		this.description = description;
		
		this.totalPrice = totalPrice;
		this.priceBeforeVAT = priceBeforeVAT;
		this.VAT = VAT;
		
	}
	
	/**
	 * 
	 */
	public String toString() {
		String str = "ItemID = " + String.valueOf(itemID) + ", Name: " + name + ", Description: " + description + ", Price: "
	+ String.valueOf(totalPrice.getValue()) + ", Price before VAT: " + String.valueOf(priceBeforeVAT.getValue()) + ", VAT amount: " + String.valueOf(VAT.getValue());
		return str;
	}
}
