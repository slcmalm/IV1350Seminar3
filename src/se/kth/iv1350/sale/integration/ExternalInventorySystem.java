package se.kth.iv1350.sale.integration;
import se.kth.iv1350.sale.model.ItemDTO;
import se.kth.iv1350.sale.model.PurchaseDTO;
import se.kth.iv1350.sale.model.Amount;
/**
 *  This class represents the external inventory system. The inventory system is currently hard coded and contains carrots (itemID 4)
 *  and potatoes (itemID 2)
 */
public class ExternalInventorySystem {

	private ItemDTO[] items;
	
	/**
	 * Initializes the inventory system. 
	 */
	public ExternalInventorySystem() {
		items = new ItemDTO[2];
		items[0] = new ItemDTO(2, "Potato", "A starchy, all-purpose potato", new Amount (4), new Amount(0), new Amount (0.25));
		items[1] = new ItemDTO(4, "Carrot", "An orange and sweet carrot", new Amount (5), new Amount(0), new Amount (0.12));	
	}
	
	/**
	 * Checks if the itemID represents a valid item in the inventory system. 
	 * @param itemID The ID of the item.
	 * @return The validity of the item.
	 */
	public boolean getItemValidity(int itemID) {
		for(int i = 0; i < items.length; i++) {
			if (items[i].itemID == itemID) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method returns the description and price of the given item. Returns null if the item is not found;
	 * @return The ItemDTO containing information about the item.
	 */
	public ItemDTO getItem(int itemID) {
		for(int i = 0; i < items.length; i++) {
			if (items[i].itemID == itemID) {
				return items[i];
			}
		}
		return null;
	}
	
	/**
	 * This method updates the external inventory system.
	 * @param saleInfo The current purchase information.
	 */
	public void updateInventory(PurchaseDTO saleInfo) {
		
	}

}
