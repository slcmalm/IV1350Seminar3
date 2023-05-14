package se.kth.iv1350.sale.model;

/**
 * This class represents a receipt which contains information about a purchase and payment.
 */
class Receipt {

	private PurchaseDTO saleInfo;
	private PaymentDTO payment;
	
	/**
	 * Creates and initializes a receipt.
	 * @param saleInfo The information about this purchase.
	 * @param payment The information about the payment used to pay for the purchase.
	 */
	Receipt(PurchaseDTO saleInfo, PaymentDTO payment) {
		this.saleInfo = saleInfo;
		this.payment = payment;
	}
		
	/**
	 * Creates and returns a ReceiptDTO containing the same field values as this Receipt.
	 * @return A ReceiptDTO containing the same field values as this Receipt.
	 */
	ReceiptDTO getReceiptDTO() {
		return new ReceiptDTO(saleInfo, payment);
	}
	
}
