package se.kth.iv1350.sale.model;

/**
 * 
 * @author Sophie
 *
 */
public class Receipt {

	private PurchaseDTO saleInfo;
	private PaymentDTO payment;
	/**
	 * 
	 * @param saleInfo
	 */
	public Receipt(PurchaseDTO saleInfo, PaymentDTO payment) {
		this.saleInfo = saleInfo;
		this.payment = payment;
	}
		
	/**
	 * 
	 * @param payment
	 * @return
	 */
	public ReceiptDTO getReceiptDTO() {
		return new ReceiptDTO(saleInfo, payment);
	}
	
}
