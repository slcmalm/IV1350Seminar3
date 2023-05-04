package se.kth.iv1350.sale.model;

/**
 * This class is a data transfer object for the Receipt class. 
 * It contains a information about a purchase and the payment.
 *
 */
public class ReceiptDTO {

	public PurchaseDTO saleInfo;
	public PaymentDTO payment;
	
	/**
	 * Initializes and creates a ReceiptDTO using a PurchaseDTO and a PaymentDTO.
	 * @param saleInfo The current purchase.
	 * @param payment The payment that was used to pay for the purchase.
	 */
	public ReceiptDTO(PurchaseDTO saleInfo, PaymentDTO payment) {
		this.saleInfo = saleInfo;
		this.payment = payment;
	}
	

	/**
	 * Returns a String containing the contents of this ReceiptDTO.
	 */
	public String toString() {
		String str = "---RECEIPT---" + "\n" + saleInfo.toString() + payment.toString() + "\n" + "---END OF RECEIPT---";
		return str;		
	}

}
