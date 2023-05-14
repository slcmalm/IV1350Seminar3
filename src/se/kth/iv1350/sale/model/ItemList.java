package se.kth.iv1350.sale.model;

import java.util.Vector;

/**
 * This class represents a list containing multiple Items.
 */
class ItemList {
	private Vector<Item> items;	
	/**
	 * Initializes and creates an ItemList.
	 */
	ItemList() {
		items = new Vector<>();
	}

	/**
	 * Creates and adds Items of a certain quantity to this ItemList.
	 * @param item The item to be added to this list.
	 * @param quantity The quantity of items to be added to this list.
	 * @return A new ItemDTO with an updated totalPrice.
	 */
	ItemDTO addItem(ItemDTO item, int quantity) {
		Item itemObj = createItem(item);
		for(int i = 0; i < quantity; i++) {
			items.add(itemObj);
		}
		return itemObj.getDTO();
	}
	
	/**
	 * Returns the quantity of items in this ItemList.
	 * @return The size of this ItemList.
	 */
	int getLength() {
		return items.size();
	}
	
	/**
	 * Calculates the total price of all Items in this ItemList.
	 * @return The total price.
	 */
	Amount getTotalPrice() {
		Amount total = new Amount(0);
		for(int i = 0; i < this.getLength(); i++) {
			total = total.add(items.elementAt(i).getTotalPrice());
		}
		return total;
	}
	
	/**
	 * 	 * Calculates the total VAT amount of all Items in this ItemList.
	 * @return The total VAT amount.
	 */
	Amount getTotalVAT() {
		Amount total = new Amount(0);
		for(int i = 0; i < this.getLength(); i++) {
			Amount itemVAT = new Amount(items.elementAt(i).getTotalPrice());
			itemVAT = itemVAT.subtract(items.elementAt(i).getPriceBeforeVAT());
			total = total.add(itemVAT);
		}
		return total;
	}
	
	/**
	 * Creates an ItemDTO array containing the same field values as the Items this ItemList.
	 * @return The ItemDTO array.
	 */
	ItemDTO[] getDTOArray() {
		ItemDTO[] itemDTOs = new ItemDTO[getLength()];
		for(int i = 0; i < getLength(); i++) {
			itemDTOs[i] = items.elementAt(i).getDTO();
		}
		return itemDTOs;	 		
	}
	
	private Item createItem(ItemDTO item) {
		return new Item(item);		
	}		
}
