package se.kth.iv1350.sale.model;

import java.time.LocalTime;

/**
 * 
 * @author Sophie
 *
 */
public class Purchase {

	private java.time.LocalTime timeOfSale;
	private ItemList itemList;
	private Discount discount;
	
	/**
	 * 
	 */
	public Purchase() {
		timeOfSale = LocalTime.now();
		itemList = new ItemList();
		discount = new Discount();	
	}
		
	/**
	 * 
	 * @param item
	 * @param quantity
	 */
	public void addItem(ItemDTO item, int quantity) {
		itemList.addItem(item, quantity); 
	}
	
	/**
	 * 
	 * @return
	 */
	public PurchaseDTO getPurchaseDTO() {
		ItemDTO[] items = itemList.getDTOArray();
		return new PurchaseDTO(timeOfSale, items, discount.getAmount(), getRunningTotal());
	} 
	
	/**
	 * 
	 * @return
	 */
	public Amount getRunningTotal() {
		return new Amount(itemList.getTotalPrice().getValue() - discount.getAmount().getValue());
	}
	
	/**
	 * 
	 * @param amount
	 */
	public void setDiscount(DiscountDTO discount) {
		this.discount = new Discount(discount);
	}
}
