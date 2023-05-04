package se.kth.iv1350.sale.model;

/**
 * This class is a data transfer object for the Item class. 
 */
public class ItemDTO {

	public int itemID;
	public String name;
	public String description;
	public Amount priceBeforeVAT;
	public Amount totalPrice;
	public Amount VATRate;
	
	/**
	 * Initializes and creates an ItemDTO.
	 * @param name The name of the item.
	 * @param description The item description.
	 * @param itemID The item ID.
	 * @param priceBeforeVAT The price of the item before adding VAT.
	 * @param VAT The VAT rate of this item.
	 */
	public ItemDTO(int itemID, String name, String description, Amount priceBeforeVAT, Amount totalPrice, Amount VATRate)
	{
		this.itemID = itemID;
		this.name = name;
		this.description = description;
		this.priceBeforeVAT = priceBeforeVAT;
		this.totalPrice = totalPrice;
		this.VATRate = VATRate;
	}
	
	/**
	 * Returns a String containing the contents of this ItemDTO.
	 */
	public String toString() {
		String str = "ItemID = " + String.valueOf(itemID) + ", Name: " + name + ", Description: " + description + ", "
				+ "Price before VAT: " + String.valueOf(priceBeforeVAT.getValue()) + ", VAT rate: " + String.valueOf(VATRate.getValue()*100) + "%" 
				+ ", Price: "+ String.valueOf(totalPrice.getValue());
		return str;
	}
}
