package se.kth.iv1350.sale.model;

/**
 * This class is a data transfer object for the Item class. 
 */
public class PaymentDTO {

	public Amount amountPaid;
	public Amount change;
	/**
	 * Initializes and creates a PaymentDTO.
	 * @param amountPaid
	 * @param change
	 */
	public PaymentDTO(Amount amountPaid, Amount change) {
		this.amountPaid = amountPaid;
		this.change = change;
	}

	/**
	 * Returns a String containing the contents of this ItemDTO.
	 */
	public String toString() {
		String str = "Amount paid: " + String.valueOf(amountPaid.getValue()) + ", Change amount: " + String.valueOf(change.getValue());
		return str;
	}

}
