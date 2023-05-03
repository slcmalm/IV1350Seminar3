package se.kth.iv1350.sale.model;

/**
 * 
 * @author Sophie
 *
 */
public class PaymentDTO {

	public Amount amountPaid;
	public Amount change;
	/**
	 * 
	 * @param amountPaid
	 * @param change
	 */
	public PaymentDTO(Amount amountPaid, Amount change) {
		this.amountPaid = amountPaid;
		this.change = change;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toString() {
		String str = "Amount paid: " + String.valueOf(amountPaid.getValue()) + ", Change amount: " + String.valueOf(change.getValue());
		return str;
	}

}
