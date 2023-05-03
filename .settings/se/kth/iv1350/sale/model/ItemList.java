package se.kth.iv1350.sale.model;

import java.util.Vector;

/**
 * An ItemList object represents a list containing Items and the quantity of each Item.
 * @author Sophie
 *
 */
public class ItemList {
	private Vector<Item> items;	
	/**
	 * 
	 */
	public ItemList() {
		items = new Vector<>();
	}
	
	/**
	 * 
	 */
	public void addItem(ItemDTO item, int quantity) {
		for(int i = 0; i < quantity; i++) {
			items.add(createItem(item));
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int getLength() {
		return items.size();
	}
	
	/**
	 * 
	 * @return
	 */
	public Amount getTotalPrice() {
		Amount total = new Amount(0);
		for(int i = 0; i < this.getLength(); i++) {
			total.setValue(total.getValue() + items.elementAt(i).getTotalPrice().getValue());
		}
		return total;
	}
	
	/**
	 * 
	 * @return
	 */
	public ItemDTO[] getDTOArray() {
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
