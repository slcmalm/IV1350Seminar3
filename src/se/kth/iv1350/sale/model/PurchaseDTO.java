package se.kth.iv1350.sale.model;

/**
 * This class is a data transfer object for the Purchase class. 
 * It contains information about the purchase, the items and the discount.
 */
public class PurchaseDTO {
	
	public final java.time.LocalDateTime dateTimeOfSale;
	public final ItemDTO[] items;
	public final Amount discount;
	public final Amount runningTotal;
	public final Amount totalVATAmount;

	/**
	 * Initializes and creates a PurchaseDTO.
	 * @param dateTimeOfSale The date and time of this purchase.
	 * @param items The items that this purchase currently contains.
	 * @param discount The current discount that is applied to this purchase.
	 * @param runningTotal The running total of this purchase.
	 * @param totalVATAmount The total amount of VAT of this purchase.
	 */
	public PurchaseDTO(java.time.LocalDateTime dateTimeOfSale, ItemDTO[] items, Amount discount, Amount runningTotal, Amount totalVATAmount) {
		this.dateTimeOfSale = dateTimeOfSale;
		this.items = items;
		this.discount = discount;
		this.runningTotal = runningTotal;
		this.totalVATAmount = totalVATAmount;
	}

	/**
	 * Returns a String containing the contents of this PurchaseDTO.
	 */
	public String toString() {
		String str = "Date and time of Purchase: " + dateTimeOfSale.toString() +
				"\n" + "Discount amount: " + String.valueOf(discount.getValue()*100)+ "%" + "\n" + "Total VAT amount:" + String.valueOf(totalVATAmount.getValue())
				+ "\n" + "Running total: " + String.valueOf(runningTotal.getValue()) + "\n";		
		
		for(int i = 0; i < items.length; i++) {
			str += items[i].toString() + "\n";
		}
		
		return str;
	}
}
