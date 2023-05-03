package se.kth.iv1350.sale.model;

/**
 * 
 * @author Sophie
 *
 */
public class PurchaseDTO {
	
	public java.time.LocalTime timeOfSale;
	public ItemDTO[] items;
	public Amount discount;
	public Amount runningTotal;

	/**
	 * 
	 */
	public PurchaseDTO(java.time.LocalTime timeOfSale, ItemDTO[] items, Amount discount, Amount runningTotal) {
		this.timeOfSale = timeOfSale;
		this.items = items;
		this.discount = discount;
		this.runningTotal = runningTotal;
	}

	/**
	 * 
	 */
	public String toString() {
		String str = "---PURCHASE INFO--- \n" + "Time of Purchase: " + timeOfSale.toString() +
				"\n" + "Discount amount: " + String.valueOf(discount.getValue()) + "\n" + "Running total: " + String.valueOf(runningTotal.getValue()) + "\n";		
		
		for(int i = 0; i < items.length; i++) {
			str += items[i].toString();
			str += "\n";
		}
		return str;
	}

}
