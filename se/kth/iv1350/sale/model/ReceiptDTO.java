package se.kth.iv1350.sale.model;

/**
 * 
 * @author Sophie
 *
 */
public class ReceiptDTO {

	public PurchaseDTO saleInfo;
	public PaymentDTO payment;
	
	/**
	 * 
	 * @param saleInfo
	 * @param payment
	 */
	public ReceiptDTO(PurchaseDTO saleInfo, PaymentDTO payment) {
		this.saleInfo = saleInfo;
		this.payment = payment;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toString() {
		String str = "---RECEIPT---" + "\n" + saleInfo.toString() + payment.toString();
		return str;		
	}

}
